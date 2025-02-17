package com.personapi.personapi.Repository;
import com.personapi.personapi.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
