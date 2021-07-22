package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PersonInDto {

    private String name;
    private String lastname;
    private String patronymic;
    private LocalDate birthday;

    public PersonInDto(String name, String lastname, String patronymic, LocalDate birthday) {
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }
}
