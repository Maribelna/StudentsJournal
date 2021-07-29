package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Boss extends Person {
    @Id
    private Long id;
    @OneToOne
    private ClassSchool classSchool;

    public Boss(String name, String lastname, String patronymic, LocalDate birthday) {
        super(name, lastname, patronymic, birthday);
    }
}
