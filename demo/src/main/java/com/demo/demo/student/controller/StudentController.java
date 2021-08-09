package com.demo.demo.student.controller;

import java.util.List;

import com.demo.demo.student.model.Student;
import com.demo.demo.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getAstStudentById(@PathVariable Long id){
        return  studentService.getAstudentById(id);
    }

    @GetMapping("/{*}")
    public ResponseEntity<String> badRequest(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/students")
    public void postStudent(@RequestBody Student s){
        studentService.postStudent(s);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

    @PutMapping("students/{id}")
    public void updateStudent(@RequestBody Student s, @PathVariable Long id){
        studentService.updateStudent(s, id);
    }

}
