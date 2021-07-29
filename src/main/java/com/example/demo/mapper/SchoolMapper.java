package com.example.demo.mapper;

import com.example.demo.dto.SchoolInDto;
import com.example.demo.dto.SchoolOutDto;
import com.example.demo.entity.ClassSchool;
import com.example.demo.entity.School;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SchoolMapper {


    public School inDtoToEntity(SchoolInDto schoolInDto) {
        return new School(schoolInDto.getNameSchool());
    }

    public SchoolOutDto entityToOutDto(School school) {
        List<Long> idClassSchoolList = new ArrayList<>();
        if(school.getClassSchools() != null){
            for(ClassSchool classSchool:school.getClassSchools()){
                idClassSchoolList.add(classSchool.getId());
                return new SchoolOutDto(school.getId(), school.getNameSchool(),idClassSchoolList);
            }
        }return new SchoolOutDto(school.getId(), school.getNameSchool(),null);
    }
}
