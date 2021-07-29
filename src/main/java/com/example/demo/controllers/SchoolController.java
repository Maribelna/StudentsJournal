package com.example.demo.controllers;

import com.example.demo.repo.SchoolRepo;
import com.example.demo.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/school")
@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @RequestMapping(value = "/add/nameSchool/idSchool", method = RequestMethod.POST)
    public ResponseEntity<String> addJournal(@RequestParam(name = "nameSchool") String nameSchool) {
        schoolService.addSchool(nameSchool);
        return ResponseEntity.ok("Cool");
    }

    @RequestMapping(value = "/remove/idSchool", method = RequestMethod.POST)
    public ResponseEntity<String> addJournal(@RequestParam(name = "idSchool") Long idSchool) {
        schoolService.removeSchool(idSchool);
        return ResponseEntity.ok("Cool");
    }
}
