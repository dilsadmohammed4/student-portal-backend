package com.student.portal.services.impl;

import com.student.portal.entities.Student;
import com.student.portal.repository.StudentRepository;
import com.student.portal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public void updateStudent(Student student, Long studentId) {
        student.setId(studentId);
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        Optional<Student> student = null;
        try {
            student = studentRepository.findById(studentId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
}
