package com.example.demo.repo;

import com.example.demo.entity.ClassSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassSchoolRepo extends JpaRepository<ClassSchool, Long> {
    List<ClassSchool> findByLetter(char letter);
    List<ClassSchool> findByLetterAndNumeral(char letter, int numeral);
    List<ClassSchool> findAllByNumeralLessThanEqualAndLetter(int numeral, char letter);



    @Query(nativeQuery = true, value = "select * from class_school cs where cs.letter = 'A' and cs.numeral <= 6")
    List<ClassSchool> selectMyClasses();

    @Query(nativeQuery = true, value = "select * from class_school cs where cs.letter = :let and cs.numeral <= :num")
    List<ClassSchool> selectMyClasses(@Param("let") char letter, @Param("num") int numeral);



    @Query(value = "select cs from ClassSchool cs where cs.letter = :let and cs.numeral <= :num")
    List<ClassSchool> selectMyClassesNotNative(@Param("let") char letter, @Param("num") int numeral);

    @Query(value = "select cs from ClassSchool cs where cs.teacher.name = :bossName")
    List<ClassSchool> selectMyClassesNotNative(@Param("bossName") String bossName);
}
