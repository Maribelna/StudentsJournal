package com.example.demo.service;

import com.example.demo.dto.RatingOutDto;

import java.util.List;

public interface RatingService {
    List<RatingOutDto> getRatingPerson (Long idPerson);


    boolean saveRating(Integer mark, String date, Long idPerson, Long idJournal);
}
