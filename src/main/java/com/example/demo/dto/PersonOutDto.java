package com.example.demo.dto;

import com.example.demo.entity.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class PersonOutDto extends Person {

    private Long id;
    private String name;
    private String lastname;
    private String patronymic;
    private LocalDate birthday;

    public PersonOutDto(Long id, String name, String lastname, String patronymic, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }
}
