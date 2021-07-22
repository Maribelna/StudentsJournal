package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RatingOutDto {
    private Long id;
    private Integer mark;
    private LocalDate localDate;
    private Long idJournals;
    private Long idPersons;

    public RatingOutDto(Long id, Integer mark, LocalDate localDate) {
        this.id = id;
        this.mark = mark;
        this.localDate = localDate;
    }

    public RatingOutDto(Long id, Integer mark, LocalDate localDate, Long idJournals, Long idPersons) {
        this.id = id;
        this.mark = mark;
        this.localDate = localDate;
        this.idJournals = idJournals;
        this.idPersons = idPersons;
    }
}
