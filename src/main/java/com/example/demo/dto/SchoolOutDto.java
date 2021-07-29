package com.example.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class SchoolOutDto {

    private Long id;
    private String nameSchool;
    private List<Long> idClassSchool;

    public SchoolOutDto(Long id, String nameSchool, List<Long> idClassSchool) {
        this.id = id;
        this.nameSchool = nameSchool;
        this.idClassSchool = idClassSchool;
    }
}
