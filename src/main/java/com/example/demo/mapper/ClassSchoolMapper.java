package com.example.demo.mapper;

import com.example.demo.dto.ClassSchoolInDto;
import com.example.demo.dto.ClassSchoolOutDto;
import com.example.demo.entity.ClassSchool;
import com.example.demo.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClassSchoolMapper {

    public ClassSchoolOutDto entityToOutDto(ClassSchool classSchool) {
        if (classSchool != null) {
            ClassSchoolOutDto classSchoolOutDto = new ClassSchoolOutDto(classSchool.getId(), classSchool.getLetter(), classSchool.getNumeral());
            List<Long> listId = new ArrayList<>();
            if (classSchool.getPersons() != null) {
                for (Person person : classSchool.getPersons()) {
                    listId.add(person.getId());
                }
                classSchoolOutDto.setPersonsIds(listId);
                return classSchoolOutDto;
            }
            classSchoolOutDto.setPersonsIds(null);
            return classSchoolOutDto;
        }
        return null;
    }

    public ClassSchool inDtoToEntity(ClassSchoolInDto classSchoolInDto) {
        return new ClassSchool(classSchoolInDto.getLetter(), classSchoolInDto.getNumeral());
    }
}
