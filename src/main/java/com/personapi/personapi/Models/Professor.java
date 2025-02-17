package com.personapi.personapi.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "professors")
public class Professor  extends Person {

    private String professorId;
    private String department;

    // Getters y Setters
    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
