package com.example.demo.controllers;

import com.example.demo.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/journal")
@RequiredArgsConstructor
public class JournalController {

    private final JournalService journalService;

    @RequestMapping(value = "/add/nameLesson/idClass",method = RequestMethod.POST)
    public ResponseEntity<String> addJournal (@RequestParam(name = "nameLesson") String nameLesson,
                                              @RequestParam(name = "idClass") Long idClass){
        journalService.addJournal(nameLesson,idClass);
        return ResponseEntity.ok("Cool");
    }

    @RequestMapping(value = "/remove/idJournal",method = RequestMethod.POST)
    public ResponseEntity<String> addJournal (@RequestParam(name = "idJournal") Long idClass){
        journalService.removeJournal(idClass);
        return ResponseEntity.ok("Cool");
    }
}
