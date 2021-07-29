package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Student extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Rating> ratings;
    @ManyToOne(cascade = CascadeType.ALL)
    private ClassSchool classSchool;
    private String description;

    public Student(String name, String lastname, String patronymic, LocalDate birthday, String description) {
        super(name, lastname, patronymic, birthday);
        this.description = description;
    }
}
