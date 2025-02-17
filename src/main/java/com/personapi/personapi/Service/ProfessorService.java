package com.personapi.personapi.Service;

import com.personapi.personapi.Models.Professor;
import java.util.List;

public interface ProfessorService {

    List<Professor> getAllProfessors();
    Professor getProfessorById(Long id);
    Professor createProfessor(Professor professor);
    Professor updateProfessor(Long id, Professor professorDetails);
    void deleteProfessor(Long id);
}
