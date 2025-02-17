package com.personapi.personapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.personapi.personapi.Service.ProfessorService;
import com.personapi.personapi.Models.Professor;
import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService; // Inyectamos la interfaz

    // Obtener todos los profesores
    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    // Obtener un profesor por su ID
    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    // Crear un nuevo profesor
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }

    // Actualizar un profesor existente
    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professorDetails) {
        return professorService.updateProfessor(id, professorDetails);
    }

    // Eliminar un profesor por su ID
    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }
}
