package com.example.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class StudentOutDto extends PersonOutDto {

    private String description;
    private ClassSchoolOutDto nameClass;

    public StudentOutDto(Long id, String name, String lastname, String patronymic, LocalDate birthday, String description, ClassSchoolOutDto nameClass) {
        super(id, name, lastname, patronymic, birthday);
        this.description = description;
        this.nameClass = nameClass;
    }


}
