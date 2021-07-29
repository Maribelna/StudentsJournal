package com.example.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BossInDto extends PersonInDto {

    public BossInDto(String name, String lastname, String patronymic, LocalDate birthday) {
        super(name, lastname, patronymic, birthday);
    }
}
