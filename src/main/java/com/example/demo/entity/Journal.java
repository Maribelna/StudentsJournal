package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Journal {

    @Id
    private Long id;
    private String nameLesson;
    @ManyToOne(fetch = FetchType.EAGER)
    private ClassSchool classSchool;
    @OneToMany
    private List<Rating> ratings;

}
