package com.restful.restful.school;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.restful.restful.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String Name;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;

    public School(String Name) {
        this.Name = Name;
    }

    public School() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
