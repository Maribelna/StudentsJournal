package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String patronymic;
    private LocalDate birthday;
    @OneToMany
    private List<Rating>  ratings;

    @ManyToOne(cascade = CascadeType.ALL)
    private ClassSchool classSchool;

    public Person(String name, String lastname, String patronymic, LocalDate birthday) {
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }
}
