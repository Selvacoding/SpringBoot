package com.restful.restful.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.restful.restful.school.School;
import com.restful.restful.student_profile.StudentProfile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Studentnew") // this @Table is not mandatory but if you want to change the name of the table
// instead of the class name as table name  and @Column also same 
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="f-name")
    private String firstname;
    private String lastname;
    @Column(unique=true)
    private String email;
    private int age;

    @OneToOne(mappedBy="st", cascade=CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    public Student(int age, String email, String firstname, String lastname) {
        this.age = age;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}
