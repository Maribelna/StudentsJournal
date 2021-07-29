package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public class RatingInDto {
    private Integer mark;
    private LocalDate localDate;
    private Long idStudents;
    private Long idJournals;

    public RatingInDto(Integer mark, LocalDate localDate, Long idStudents, Long idJournals) {
        this.mark = mark;
        this.localDate = localDate;
        this.idStudents = idStudents;
        this.idJournals = idJournals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingInDto that = (RatingInDto) o;
        return mark.equals(that.mark) && localDate.equals(that.localDate) && idStudents.equals(that.idStudents) && idJournals.equals(that.idJournals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, localDate, idStudents, idJournals);
    }
}
