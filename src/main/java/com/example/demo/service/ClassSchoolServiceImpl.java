package com.example.demo.service;

import com.example.demo.dto.ClassSchoolInDto;
import com.example.demo.dto.ClassSchoolOutDto;
import com.example.demo.entity.ClassSchool;
import com.example.demo.mapper.ClassSchoolMapper;
import com.example.demo.repo.ClassSchoolRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassSchoolServiceImpl implements ClassSchoolService {

    private final ClassSchoolMapper classSchoolMapper;
    private final ClassSchoolRepo classSchoolRepo;

    @Override
    public ClassSchoolOutDto saveClassSchool(ClassSchoolInDto classSchoolInDto) {
        ClassSchool classSchool = classSchoolMapper.inDtoToEntity(classSchoolInDto);
        classSchoolRepo.save(classSchool);
        return classSchoolMapper.entityToOutDto(classSchool);
    }

    @Override
    public List<ClassSchoolOutDto> allClass() {
        List<ClassSchool> listEntity = classSchoolRepo.findAll();
        List<ClassSchoolOutDto> listDto = new ArrayList<>();
        for (ClassSchool classSchool : listEntity)
            listDto.add(classSchoolMapper.entityToOutDto(classSchool));
        return listDto;
    }

    @Override
    public ClassSchoolOutDto getInfo(Long id) {
        Optional<ClassSchool> classSchoolOpt = classSchoolRepo.findById(id);
        if (classSchoolOpt.isEmpty())
            throw new RuntimeException(String.format("Not found value with id=%s", id));
        else return classSchoolMapper.entityToOutDto(classSchoolOpt.get());
    }


}
