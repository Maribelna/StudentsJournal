package com.example.demo.repo;

import com.example.demo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void findByName() {
        Person person = studentRepo.findByName("Marina");
        log.info(person.toString());
    }

    @Test
    public void findAllByClassSchool() {
    }
}