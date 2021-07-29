package com.example.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BossOutDto extends PersonOutDto {

    private Long idClass;

    public BossOutDto(Long id, String name, String lastname, String patronymic, LocalDate birthday, Long idClass) {
        super(id, name, lastname, patronymic, birthday);
        this.idClass = idClass;
    }
}
