package com.example.demo.mapper;

import com.example.demo.dto.JournalInDto;
import com.example.demo.dto.JournalOutDto;
import com.example.demo.entity.ClassSchool;
import com.example.demo.entity.Journal;
import com.example.demo.entity.Rating;
import com.example.demo.repo.ClassSchoolRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JournalMapper {

    private final ClassSchoolRepo classSchoolRepo;

    public Journal inDtoToEntity(JournalInDto journalInDto){
        Optional<ClassSchool> classSchoolOpt =classSchoolRepo.findById(journalInDto.getIdClassSchool());
        if (classSchoolOpt.isEmpty()) {
            throw new RuntimeException(String.format("Сущность с id=%s не найдена",journalInDto.getIdClassSchool()));
        }else {
            ClassSchool classSchool = classSchoolOpt.get();
            return new Journal(journalInDto.getNameLesson(), classSchool);
        }
    }

    public JournalOutDto entityToOutDto(Journal journal){
        List<Long> idRatings = new ArrayList<>();
        if(journal.getRatings() != null){
            for (Rating rating: journal.getRatings())
                idRatings.add(rating.getId());
        }else return null;
        return new JournalOutDto(journal.getId(), journal.getNameLesson(),idRatings
                , journal.getClassSchool().getId());
    }
}
