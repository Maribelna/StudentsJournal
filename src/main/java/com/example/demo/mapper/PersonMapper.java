package com.example.demo.mapper;

import com.example.demo.dto.BossInDto;
import com.example.demo.dto.BossOutDto;
import com.example.demo.dto.StudentInDto;
import com.example.demo.dto.StudentOutDto;
import com.example.demo.entity.Boss;
import com.example.demo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {

    private final ClassSchoolMapper classSchoolMapper;

    public Student studentDtoToEntity(StudentInDto studentInDto) {
        return new Student(studentInDto.getName(), studentInDto.getLastname(), studentInDto.getPatronymic(), studentInDto.getBirthday(), studentInDto.getDescription());
    }

    public Boss bossDtoToEntity(BossInDto bossInDto) {
        return new Boss(bossInDto.getName(), bossInDto.getLastname(), bossInDto.getPatronymic(), bossInDto.getBirthday());
    }

    public StudentOutDto studentEntityToDto(Student student) {
        return new StudentOutDto(student.getId(), student.getName(), student.getLastname()
                , student.getPatronymic(), student.getBirthday(), student.getDescription(), classSchoolMapper.entityToOutDto(student.getClassSchoolForStudent()));
    }

    public BossOutDto bossEntityToDto(Boss boss) {
        return new BossOutDto(boss.getId(), boss.getName(), boss.getLastname(), boss.getPatronymic(),
                boss.getBirthday(), boss.getClassSchoolForTeacher().getId());
    }
}
