package com.demo.demo.student.repository;

import com.demo.demo.student.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
    public Student findByRn(String rn);
    public Student findByEmail(String email);
}
