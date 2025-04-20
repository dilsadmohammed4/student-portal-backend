package com.student.portal.controller;

import com.student.portal.entities.Student;
import com.student.portal.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> createUser(@RequestBody Student student) {
        Student user = studentService.saveStudent(student);
        log.info("student created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // all student get
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllUser() {
        List<Student> allUser = studentService.getAllStudent();
        log.info("all student list fetched successfully");
        return ResponseEntity.ok(allUser);
    }


    // Single Book
    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") Long studentId) {

        Optional<Student> student = studentService.getStudentById(studentId);
        log.info("student fetched by id successfully");
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(student);
    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") Long studentId) {

        try {
            log.info("student deleted successfully");
            this.studentService.deleteStudent(studentId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // Update book handler
    @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("studentId") Long studentId) {
        try {
            studentService.updateStudent(student, studentId);
            log.info("student updated successfully");
            return ResponseEntity.ok().body(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
