package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JournalOutDto {
    private Long id;
    private String nameLesson;
    private List<Long> idRatings;
    private Long idClassSchool;

    public JournalOutDto(Long id, String nameLesson, List<Long> idRatings, Long idClassSchool) {
        this.id = id;
        this.nameLesson = nameLesson;
        this.idRatings = idRatings;
        this.idClassSchool = idClassSchool;
    }
}
