package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class ClassSchool {

    @Id
    @GeneratedValue
    private Long id;
    private char letter;
    private int numeral;
    @OneToOne
    private Boss teacher;
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Student> students;
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Journal> journals;
    @ManyToOne
    private School school;

    public ClassSchool(char letter, int numeral) {
        this.letter = letter;
        this.numeral = numeral;
    }

    public ClassSchool(Long id, char letter, int numeral) {
        this.id = id;
        this.letter = letter;
        this.numeral = numeral;
    }

}


