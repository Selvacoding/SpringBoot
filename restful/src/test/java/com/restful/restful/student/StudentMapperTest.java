package com.restful.restful.student;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentMapperTest {

    private StudentMapper studentMapper;
    private Student student;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentStoToStudent() {
        StudentDto dto = new StudentDto(
                "selva",
                "murugan",
                "selvamurugan2649@gmail.com",
                1);

        Student student = studentMapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.school_id(), student.getSchool().getId());

    }

    @Test
    public void should_throw_null_pointer_exceprion_when_studentDto_is_null() {

        var msg = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
        assertEquals("this should not be null", msg.getMessage());
    }
    
    @Test
    public void ShouldMapStudentToStudentResponseDto() {
        // Given
        student = new Student(12, "email", "s", "m");

        // When
        StudentResponseDto responseDto = studentMapper.toStudentResponseDto(student);

        // Then
        assertEquals(student.getFirstname(), responseDto.firstname());
        assertEquals(student.getLastname(), responseDto.lastname());
        assertEquals(student.getEmail(), responseDto.email());

    }
    

}
