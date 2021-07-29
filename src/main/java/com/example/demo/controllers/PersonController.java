package com.example.demo.controllers;

import com.example.demo.DateTimeUtils;
import com.example.demo.dto.*;
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


    @RequestMapping(value = "/getStudent", method = RequestMethod.GET)
    public ResponseEntity<PersonInDto> getJsonStudent() {
        StudentInDto studentInDto = new StudentInDto();
        studentInDto.setBirthday(DateTimeUtils.strToLocalDate("2013-10-14"));
        studentInDto.setName("Petr");
        log.info("ok");
        return ResponseEntity.ok(studentInDto);
    }

    @RequestMapping(value = "/getBoss", method = RequestMethod.GET)
    public ResponseEntity<PersonInDto> getJsonBoss() {
        BossInDto bossInDto = new BossInDto();
        bossInDto.setBirthday(DateTimeUtils.strToLocalDate("1986-04-06"));
        bossInDto.setName("Marina");
        log.info("ok");
        return ResponseEntity.ok(bossInDto);
    }

    @SneakyThrows
    @RequestMapping(value = "/saveStudent/json", method = RequestMethod.POST)
    public ResponseEntity<PersonOutDto> saveStudent(@RequestParam(name = "json") String name) {
        StudentInDto studentInDto = objectMapper.readValue(name, StudentInDto.class);
        StudentOutDto savedStudent = personService.saveStudent(studentInDto);
        return ResponseEntity.ok(savedStudent);
    }

    @SneakyThrows
    @RequestMapping(value = "/saveBoss/json", method = RequestMethod.POST)
    public ResponseEntity<PersonOutDto> saveBoss(@RequestParam(name = "json") String name) {
        BossInDto bossInDto = objectMapper.readValue(name, BossInDto.class);
        BossOutDto savedBoss = personService.saveBoss(bossInDto);
        return ResponseEntity.ok(savedBoss);
    }

    @RequestMapping(value = "/allStudent", method = RequestMethod.GET)
    public ResponseEntity<List<StudentOutDto>> getAllStudent() {
        return ResponseEntity.ok(personService.allStudent());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<BossOutDto>> getAllBoss() {
        return ResponseEntity.ok(personService.allBoss());
    }
}
