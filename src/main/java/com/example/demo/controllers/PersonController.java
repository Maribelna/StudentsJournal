package com.example.demo.controllers;

import com.example.demo.DateTimeUtils;
import com.example.demo.dto.PersonInDto;
import com.example.demo.dto.PersonOutDto;
import com.example.demo.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;
    private final ObjectMapper objectMapper;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<PersonInDto> getJson() {
        PersonInDto personInDto = new PersonInDto();
        personInDto.setBirthday(DateTimeUtils.strToLocalDate("2013-10-14"));
        personInDto.setName("Petr");
        log.info("ok");
        return ResponseEntity.ok(personInDto);
    }

    @SneakyThrows
    @RequestMapping(value = "/save/json", method = RequestMethod.POST)
    public ResponseEntity<PersonOutDto> savePerson(@RequestParam(name = "json") String name) {
        PersonInDto personInDto = objectMapper.readValue(name, PersonInDto.class);
        PersonOutDto savedPerson = personService.savePerson(personInDto);
        return ResponseEntity.ok(savedPerson);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<PersonOutDto>> getAllPerson() {
        return ResponseEntity.ok(personService.allPerson());
    }


}
