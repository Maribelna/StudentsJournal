package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClassSchoolOutDto {

    private Long id;
    private char letter;
    private int numeral;
    private List<Long> personsIds;

    public ClassSchoolOutDto(Long id, char letter, int numeral) {
        this.id = id;
        this.letter = letter;
        this.numeral = numeral;
    }
}
