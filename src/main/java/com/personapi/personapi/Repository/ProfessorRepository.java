package com.personapi.personapi.Repository;

import com.personapi.personapi.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;   

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
