package com.example.demo.controllers;

import com.example.demo.dto.ClassSchoolInDto;
import com.example.demo.dto.ClassSchoolOutDto;
import com.example.demo.service.ClassSchoolService;
import com.example.demo.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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
@RequestMapping(value = "/class")
public class ClassSchoolController {

    private final ClassSchoolService classSchoolService;
    private final PersonService personService;
    private final ObjectMapper objectMapper;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<ClassSchoolInDto> getJson() {
        ClassSchoolInDto classSchoolInDto = new ClassSchoolInDto();
        classSchoolInDto.setLetter('A');
        classSchoolInDto.setNumeral(5);
        log.info("ok");
        return ResponseEntity.ok(classSchoolInDto);
    }

    @RequestMapping(value = "/enrollment/idClass/idPerson", method = RequestMethod.GET)
    public ResponseEntity<String> enrollment(@RequestParam(name = "idClass") Long idClass,
                                             @RequestParam(name = "idPerson") Long idPerson) {
        personService.enrollment(idPerson, idClass);
        return ResponseEntity.ok("Enrollment was successful");
    }

    @RequestMapping(value = "/save/classSchool", method = RequestMethod.POST)
    public ResponseEntity<ClassSchoolOutDto> saveClass(@RequestParam(name = "classSchool") String st) throws JsonProcessingException {
        ClassSchoolInDto classSchoolInDto = objectMapper.readValue(st, ClassSchoolInDto.class);
        ClassSchoolOutDto classSchoolOutDto = classSchoolService.saveClassSchool(classSchoolInDto);
        return ResponseEntity.ok(classSchoolOutDto);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ClassSchoolOutDto>> list() {
        return ResponseEntity.ok(classSchoolService.allClass());
    }

    @RequestMapping(value = "/search/idClass", method = RequestMethod.POST)
    public ResponseEntity<ClassSchoolOutDto> getInfoClass(@RequestParam(name = "idClass") Long id) {
        return ResponseEntity.ok(classSchoolService.getInfo(id));
    }
}
