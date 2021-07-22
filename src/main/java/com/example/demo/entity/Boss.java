package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data

public class Boss extends Person{
    @Id
    private Long id;
    @ManyToOne
    private ClassSchool classSchool;
}
