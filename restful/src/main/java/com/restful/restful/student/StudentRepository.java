package com.restful.restful.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    public List<Student> findAllByFirstnameContaining(String parameter);
}
