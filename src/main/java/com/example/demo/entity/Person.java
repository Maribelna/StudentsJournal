package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Person {

    private String name;
    private String lastname;
    private String patronymic;
    private LocalDate birthday;

    public Person(String name, String lastname, String patronymic, LocalDate birthday) {
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }
}
