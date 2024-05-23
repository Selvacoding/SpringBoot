package com.restful.restful.student;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }
    
    public StudentResponseDto saveStudent(StudentDto studentdto) {
        var student = studentMapper.toStudent(studentdto);
        var savedStudents = studentRepo.save(student);
        return studentMapper.toStudentResponseDto(savedStudents);
    }
    
    public List<StudentResponseDto> getStudentsDetail() {
        List<Student> students = studentRepo.findAll();
        return students.stream()
                       .map(studentMapper::toStudentResponseDto)
                       .collect(Collectors.toList());
    }

    public StudentResponseDto getStudentDetail(Integer id) {
        return studentRepo.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findAllByName(String name) {
        List<Student> students = studentRepo.findAllByFirstnameContaining(name);
        return students.stream()
                       .map(studentMapper::toStudentResponseDto)
                       .collect(Collectors.toList());
    }

    public void delete(int id) {
        studentRepo.deleteById(id);
    }


}
