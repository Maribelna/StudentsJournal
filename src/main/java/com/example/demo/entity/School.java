package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class School {

    @Id
    private Long id;
    @OneToMany
    private List<ClassSchool> classSchools;
}
