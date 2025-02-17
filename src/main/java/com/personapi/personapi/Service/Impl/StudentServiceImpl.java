package com.personapi.personapi.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personapi.personapi.Models.Student;
import com.personapi.personapi.Repository.StudentRepository;
import com.personapi.personapi.Service.StudentService;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
     @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setAge(studentDetails.getAge());
            student.setEmail(studentDetails.getEmail());
            student.setPhoneNumber(studentDetails.getPhoneNumber());
            student.setAddress(studentDetails.getAddress());
            student.setStudentId(studentDetails.getStudentId());
            student.setMajor(studentDetails.getMajor());
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
