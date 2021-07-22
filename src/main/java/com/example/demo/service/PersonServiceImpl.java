package com.example.demo.service;

import com.example.demo.dto.PersonInDto;
import com.example.demo.dto.PersonOutDto;
import com.example.demo.entity.ClassSchool;
import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.repo.ClassSchoolRepo;
import com.example.demo.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;
    private final PersonMapper personMapper;
    private final ClassSchoolRepo classSchoolRepo;

    @Override
    public PersonOutDto savePerson(PersonInDto personInDto) {
        Person person = personMapper.dtoToEntity(personInDto);
        personRepo.save(person);
        return personMapper.entityToDto(person);
    }

    @Override
    public List<PersonOutDto> allPerson() {
        List<Person> listEntity = personRepo.findAll();
        List<PersonOutDto> listDto = new ArrayList<>();
        for (Person person : listEntity) {
            listDto.add(personMapper.entityToDto(person));
        }
        return listDto;
    }

    @Override
    public boolean enrollment(Long idPerson, Long idClass) {
        Optional<Person> personOpt = personRepo.findById(idPerson);
        Person person = personOpt.orElseThrow(() -> new RuntimeException(String.format("Сущность с id=%s не найдена!", idPerson)));
        Optional<ClassSchool> classSchoolOpt = classSchoolRepo.findById(idClass);
        ClassSchool classSchool = classSchoolOpt.orElseThrow(() -> new RuntimeException(String.format("Сущность с id=%s не найдена!", idClass)));
        person.setClassSchool(classSchool);
        PersonOutDto personOutDto = personMapper.entityToDto(person);
        return true;
    }
}
