package com.example.demo.mapper;

import com.example.demo.dto.PersonInDto;
import com.example.demo.dto.PersonOutDto;
import com.example.demo.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {

    private final ClassSchoolMapper classSchoolMapper;

    public Person dtoToEntity(PersonInDto personInDto){
        Person studentInfo = new Person(personInDto.getName(), personInDto.getLastname(), personInDto.getPatronymic(), personInDto.getBirthday());
        return studentInfo;
    }

    public PersonOutDto entityToDto (Person person){
        PersonOutDto personOutDto = new PersonOutDto(person.getId(), person.getName(), person.getLastname()
                ,person.getPatronymic(), person.getBirthday(), classSchoolMapper.entityToOutDto(person.getClassSchool()));
        return personOutDto;
    }
}
