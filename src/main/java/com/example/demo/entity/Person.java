package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {

    @Id
    private Long id;
    @Column(name = "name_person")
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
