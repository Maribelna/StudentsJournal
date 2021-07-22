package com.example.demo.service;

import com.example.demo.dto.ClassSchoolInDto;
import com.example.demo.dto.ClassSchoolOutDto;
import com.example.demo.entity.ClassSchool;

import java.util.List;

public interface ClassSchoolService {
    ClassSchoolOutDto saveClassSchool (ClassSchoolInDto classSchoolInDto);
    List<ClassSchoolOutDto> allClass ();
    ClassSchoolOutDto getInfo(Long id);
}
