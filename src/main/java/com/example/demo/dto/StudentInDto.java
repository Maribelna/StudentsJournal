package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public class StudentInDto extends PersonInDto {

    private String description;

    public StudentInDto(String name, String lastname, String patronymic, LocalDate birthday, String description) {
        super(name, lastname, patronymic, birthday);
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentInDto that = (StudentInDto) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description);
    }
}
