package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Journal {

    @Id
    private Long id;
    private String nameLesson;
    @ManyToOne(fetch = FetchType.EAGER)
    private ClassSchool classSchool;
    @OneToMany
    private List<Rating> ratings;

    public Journal(String nameLesson, ClassSchool classSchool) {
        this.nameLesson = nameLesson;
        this.classSchool = classSchool;
    }
}
