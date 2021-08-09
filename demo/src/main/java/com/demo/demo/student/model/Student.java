package com.demo.demo.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fname;
    @Column
    private String email;
    @Column
    private String rn;

    public Student(Long id, String fname, String email, String rn) {
        this.id = id;
        this.fname = fname;
        this.email = email;
        this.rn = rn;
    }

    public Student(String fname, String email, String rn) {
        this.fname = fname;
        this.email = email;
        this.rn = rn;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }
}
