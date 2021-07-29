package com.example.demo.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Rating {

    @Id
    private Long id;
    private Integer mark;
    private LocalDate localDate;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Journal journal;
    private static final List<Rating> ratings= new ArrayList<>();

    public Rating(Integer mark, LocalDate localDate) {
        this.mark = mark;
        this.localDate = localDate;
    }
}
