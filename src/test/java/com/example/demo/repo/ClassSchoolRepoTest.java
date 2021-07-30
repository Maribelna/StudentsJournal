package com.example.demo.repo;

import com.example.demo.entity.ClassSchool;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
@Slf4j
class ClassSchoolRepoTest {

    @Autowired
    ClassSchoolRepo repo;

    @Test
    void findByLetter() {
        List<ClassSchool> arr = repo.findByLetter('A');
        log.info(arr.toString());
    }

    @Test
    void findByNumeralLessThanEqualAndLetter() {
        List<ClassSchool> arr = repo.findAllByNumeralLessThanEqualAndLetter(6,'A');
        log.info(arr.toString());
    }

    @Test
    void selectMyClasses() {
        List<ClassSchool> arr = repo.selectMyClasses('A', 6);
        log.info(arr.toString());
    }

//    @Test
//    void selectMyClassesNotNative() {
//        List<ClassSchool> arr = repo.selectMyClassesNotNative('A', 6);
//        log.info(arr.toString());
//    }
//
//    @Test
//    void selectMyClassesNotNative2() {
//        List<ClassSchool> arr = repo.selectMyClassesNotNative("Marina");
//        log.info(arr.toString());
//    }
}