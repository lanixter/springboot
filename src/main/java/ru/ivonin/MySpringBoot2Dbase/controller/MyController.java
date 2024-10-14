package ru.ivonin.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivonin.MySpringBoot2Dbase.entity.Student;
import ru.ivonin.MySpringBoot2Dbase.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(Math.toIntExact(id));
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        try {
            studentService.saveStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create student");
        }
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        try {
            studentService.saveStudent(student);
            return ResponseEntity.ok("Student successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update student");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(Math.toIntExact(id));
            return ResponseEntity.ok("Student successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }
}
