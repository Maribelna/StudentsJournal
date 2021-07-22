package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class JournalOutDto {
    private Long id;
    private String nameLesson;
    private List<Long> idRatings;
    private Long idClassSchool;
}
