package com.student.portal.services;

import com.student.portal.entities.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudent();

    void deleteStudent(Long studentId);

    void updateStudent(Student student, Long studentId);

    Optional<Student> getStudentById(Long studentId);

}
