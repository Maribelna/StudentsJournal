package com.example.demo.repo;

import com.example.demo.entity.ClassSchool;
import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person,Long> {
    Person findByName(String name);
    List<Person> findAllByClassSchool(ClassSchool classSchool);


}
