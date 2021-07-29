package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface PersonService {

    StudentOutDto saveStudent(StudentInDto studentInDto);

    BossOutDto saveBoss(BossInDto bossInDto);

    List<StudentOutDto> allStudent();

    List<BossOutDto> allBoss();

    boolean enrollmentStudent(Long idStudent, Long idClass);

    boolean enrollmentBoss(Long idBoss, Long idClass);
}
