package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassSchoolInDto {

    private char letter;
    private int numeral;

    public ClassSchoolInDto(char letter, int numeral) {
        this.letter = letter;
        this.numeral = numeral;
    }
}
