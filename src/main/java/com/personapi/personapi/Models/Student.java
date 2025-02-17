package com.personapi.personapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student extends Person {

    private String studentId;
    private String major;

    // Getters y Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
