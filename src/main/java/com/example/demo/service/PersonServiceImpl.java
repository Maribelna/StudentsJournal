package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Boss;
import com.example.demo.entity.ClassSchool;
import com.example.demo.entity.Person;
import com.example.demo.entity.Student;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.repo.BossRepo;
import com.example.demo.repo.ClassSchoolRepo;
import com.example.demo.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final StudentRepo studentRepo;
    private final BossRepo bossRepo;
    private final PersonMapper personMapper;
    private final ClassSchoolRepo classSchoolRepo;

    @Override
    public StudentOutDto saveStudent(StudentInDto studentInDto) {
        Student student = personMapper.studentDtoToEntity(studentInDto);
        studentRepo.save(student);
        return personMapper.studentEntityToDto(student);
    }

    @Override
    public BossOutDto saveBoss(BossInDto bossInDto) {
        Boss boss = personMapper.bossDtoToEntity(bossInDto);
        bossRepo.save(boss);
        return personMapper.bossEntityToDto(boss);
    }

    @Override
    public List<StudentOutDto> allStudent() {
        List<Student> listEntity = studentRepo.findAll();
        List<StudentOutDto> listDto = new ArrayList<>();
        for (Student student : listEntity) {
            listDto.add(personMapper.studentEntityToDto(student));
        }
        return listDto;
    }

    @Override
    public List<BossOutDto> allBoss() {
        List<Boss> listEntity = bossRepo.findAll();
        List<BossOutDto> listDto = new ArrayList<>();
        for (Boss boss : listEntity) {
            listDto.add(personMapper.bossEntityToDto(boss));
        }
        return listDto;
    }

    @Override
    public boolean enrollmentStudent(Long idStudent, Long idClass) {
        Optional<Student> studentOpt = studentRepo.findById(idStudent);
        Student student = studentOpt.orElseThrow(() -> new RuntimeException(String.format("Сущность с id=%s не найдена!", idStudent)));
        Optional<ClassSchool> classSchoolOpt = classSchoolRepo.findById(idClass);
        ClassSchool classSchool = classSchoolOpt.orElseThrow(() -> new RuntimeException(String.format("Сущность с id=%s не найдена!", idClass)));
        student.setClassSchool(classSchool);
        PersonOutDto personOutDto = personMapper.studentEntityToDto(student);
        return true;
    }

    @Override
    public boolean enrollmentBoss(Long idBoss, Long idClass) {
        Optional<Boss> bossOpt = bossRepo.findById(idBoss);
        Boss boss = bossOpt.orElseThrow(() -> new RuntimeException(String.format("Сущность с id=%s не найдена!", idBoss)));
        Optional<ClassSchool> classSchoolOpt = classSchoolRepo.findById(idClass);
        ClassSchool classSchool = classSchoolOpt.orElseThrow(() -> new RuntimeException(String.format("Сущность с id=%s не найдена!", idClass)));
        boss.setClassSchool(classSchool);
        PersonOutDto personOutDto = personMapper.bossEntityToDto(boss);
        return true;
    }
}
