package com.example.demo.repo;

import com.example.demo.entity.ClassSchool;
import com.example.demo.entity.Person;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {
    Student findByName(String name);



}
