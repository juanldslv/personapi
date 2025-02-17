package com.personapi.personapi.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personapi.personapi.Models.Professor;
import com.personapi.personapi.Repository.ProfessorRepository;
import com.personapi.personapi.Service.ProfessorService;
import java.util.List;
@Service
public class ProfessorServiceImpl implements ProfessorService {

    
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @Override
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor updateProfessor(Long id, Professor professorDetails) {
        Professor professor = professorRepository.findById(id).orElse(null);
        if (professor != null) {
            professor.setFirstName(professorDetails.getFirstName());
            professor.setLastName(professorDetails.getLastName());
            professor.setAge(professorDetails.getAge());
            professor.setEmail(professorDetails.getEmail());
            professor.setPhoneNumber(professorDetails.getPhoneNumber());
            professor.setAddress(professorDetails.getAddress());
            professor.setProfessorId(professorDetails.getProfessorId());
            professor.setDepartment(professorDetails.getDepartment());
            return professorRepository.save(professor);
        }
        return null;
    }

    @Override
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}
