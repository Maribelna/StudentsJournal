package com.example.demo.service;

import com.example.demo.dto.PersonInDto;
import com.example.demo.dto.PersonOutDto;

import java.util.List;

public interface PersonService {
    PersonOutDto savePerson(PersonInDto personinDto);

    List<PersonOutDto> allPerson();

    boolean enrollment(Long id, Long idClass);
}
