package com.example.demo.service;

import com.example.demo.dto.ClassSchoolInDto;
import com.example.demo.dto.ClassSchoolOutDto;
import com.example.demo.entity.ClassSchool;
import com.example.demo.mapper.ClassSchoolMapper;
import com.example.demo.repo.ClassSchoolRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ClassSchoolServiceImplTest {

    @Autowired
    private ClassSchoolServiceImpl classSchoolService;
    @Autowired
    private ClassSchoolMapper classSchoolMapper;
    @MockBean
    private ClassSchoolRepo classSchoolRepo;

    private ClassSchoolInDto classSchoolInDto;

    @BeforeEach
    public void data() {
        classSchoolInDto = new ClassSchoolInDto('A', 1);
    }

    @Test
    void saveClassSchool() {
        ClassSchoolOutDto expected = classSchoolService.saveClassSchool(classSchoolInDto);
        ClassSchool classSchool = classSchoolMapper.inDtoToEntity(classSchoolInDto);
        Mockito.verify(classSchoolRepo, Mockito.times(1)).save(classSchool);
        assertNotNull(expected);
        //id = null  ??
    }

    @Test
    void allClass() {
        List<ClassSchool> listEntity = new ArrayList<>();
        listEntity.add(new ClassSchool(10L,'A',1));
        listEntity.add(new ClassSchool(11L,'B',2));
        listEntity.add(new ClassSchool(12L,'S',1));
        listEntity.add(new ClassSchool(13L,'A',7));
        List<ClassSchoolOutDto> listDto = new ArrayList<>();
        listDto.add(new ClassSchoolOutDto(10L,'A',1));
        listDto.add(new ClassSchoolOutDto(11L,'B',2));
        listDto.add(new ClassSchoolOutDto(12L,'S',1));
        listDto.add(new ClassSchoolOutDto(13L,'A',7));
        Mockito.when(classSchoolRepo.findAll()).thenReturn(listEntity);

         assertEquals(listDto,classSchoolService.allClass());
    }

    @Test
    void getInfo() {
        Mockito.when(classSchoolRepo.findById(any())).thenReturn(Optional.of(new ClassSchool(10L,'A',1)));
        ClassSchoolOutDto expected = new ClassSchoolOutDto(10L,'A',1);
        ClassSchoolOutDto actual = classSchoolService.getInfo(10L);
        assertEquals(expected,actual);
    }
}