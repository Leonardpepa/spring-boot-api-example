package com.demo.demo.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.demo.student.model.Student;
import com.demo.demo.student.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student getAstudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        else{
            throw new IllegalArgumentException("Student with that particular id not found");
        }
    }
    
    public void postStudent(Student s){
        if(studentRepository.findByRn(s.getRn()) == null){
            studentRepository.save(s);
        }
    }
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);;
    }
    public void updateStudent(Student s, Long id) {
        Optional<Student> studentRetrieved = studentRepository.findById(id);
        studentRetrieved.ifPresent(student -> {
            if(s.getFname() != null && !s.getFname().equals(student.getFname())){
                student.setFname(s.getFname());
            }

            if(s.getEmail() != null && !s.getEmail().equals(student.getEmail())){
                student.setEmail(s.getEmail());
            }

            if(s.getRn() != null && !s.getRn().equals(student.getRn())){
                student.setRn(s.getRn());
            }
            studentRepository.save(student);
        }
        );
    }
}
