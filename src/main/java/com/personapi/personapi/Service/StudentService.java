package com.personapi.personapi.Service;

import com.personapi.personapi.Models.Student;
import java.util.List;

public interface StudentService {
    
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student studentDetails);
    void deleteStudent(Long id);

}
