package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JournalInDto {
    private String nameLesson;
    private Long idClassSchool;

    public JournalInDto(String nameLesson, Long idClassSchool) {
        this.nameLesson = nameLesson;
        this.idClassSchool = idClassSchool;
    }
}
