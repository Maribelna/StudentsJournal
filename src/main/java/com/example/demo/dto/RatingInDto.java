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
    private Long idPersons;
    private Long idJournal;

    public RatingInDto(Integer mark, LocalDate localDate, Long idPersons, Long idJournal) {
        this.mark = mark;
        this.localDate = localDate;
        this.idPersons = idPersons;
        this.idJournal = idJournal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingInDto that = (RatingInDto) o;
        return mark.equals(that.mark) && localDate.equals(that.localDate) && idPersons.equals(that.idPersons) && idJournal.equals(that.idJournal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, localDate, idPersons, idJournal);
    }
}
