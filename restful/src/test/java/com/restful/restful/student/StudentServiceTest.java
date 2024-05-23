package com.restful.restful.student;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StudentServiceTest {

    // which service we want to test

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepo;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testDelete() {

    }

    @Test
    void testFindAllByName() {

    }

    @Test
    void testGetStudentDetail() {
        // Given 
        StudentDto dto = new StudentDto(
                "Selva",
                "Murugan",
                "email",
                1
        );
        
        Integer id = 1;


        // When 
        StudentResponseDto response = studentService.getStudentDetail(id);

        // assertEquals(, response.getId());
    }

    @Test
    void should_return_all_student() {
        // Given
        List<Student> students = Arrays.asList(
                new Student(20, "email1", "Selva", "Murugan"),
                new Student(23, "email2", "virat", "kohli")
        );

        List<StudentResponseDto> expectedResponseDtos = Arrays.asList(
                new StudentResponseDto("Selva", "Murugan", "email1"),
                new StudentResponseDto("virat", "kohli", "email2")
        );

        // Mock the calls
        when(studentRepo.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenAnswer(invocation -> {
            Student student = invocation.getArgument(0);
            return new StudentResponseDto(student.getFirstname(), student.getLastname(), student.getEmail());
        });

        // When
        List<StudentResponseDto> responseDto = studentService.getStudentsDetail();

        // Then
        assertEquals(expectedResponseDtos.get(0), responseDto.get(0));
        assertEquals(expectedResponseDtos.get(1), responseDto.get(1));

        verify(studentRepo, times(1)).findAll();

    }

    @Test
    void should_successfully_save_a_student() {
        // Given
        StudentDto dto = new StudentDto(
                "Selva",
                "Murugan",
                "email",
                1
        );

        Student student = new Student(
                        20,
                        "email",
                        "Selva",
                        "Murugan"
        );

        Student savedStudent = new Student(
                        20,
                        "email",
                        "Selva",
                        "Murugan"
        );

        savedStudent.setId(1);

        // Mock the calls
        when(studentMapper.toStudent(dto))
                .thenReturn(student);
        when(studentRepo.save(student))
                .thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto("Selva", "Murugan", "email"));
        

        // When
        StudentResponseDto response = studentService.saveStudent(dto);

        // Then
        assertEquals(response.firstname(), dto.firstname());
        assertEquals(response.lastname(), dto.lastname());
        assertEquals(response.email(), dto.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(studentRepo, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(savedStudent);
            
    }
    

}
