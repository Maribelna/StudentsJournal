package com.example.demo.controllers;

import com.example.demo.dto.RatingOutDto;
import com.example.demo.entity.Rating;
import com.example.demo.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @RequestMapping(value = "/show/idPerson",method = RequestMethod.GET)
    private ResponseEntity<List<RatingOutDto>> getInfoJournal(@RequestParam(name = "idPerson") Long idPerson){
        List<RatingOutDto> ratingList = ratingService.getRatingPerson(idPerson);
        return ResponseEntity.ok(ratingList);
    }

    @RequestMapping(value = "/add/mark/date/idPersons/idJournal",method =RequestMethod.POST)
    public ResponseEntity<String> addRating (@RequestParam(name = "mark") Integer mark,
                                             @RequestParam(name = "date") String date,
                                             @RequestParam(name = "idPersons",required = false) Long idPersons,
                                             @RequestParam(name = "idJournal",required = false) Long idJournal){
        ratingService.saveRating(mark, date, idPersons, idJournal);
        return ResponseEntity.ok("Saving was successful");
    }
}
