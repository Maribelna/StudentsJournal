package com.example.demo.service;

import com.example.demo.entity.School;
import com.example.demo.repo.ClassSchoolRepo;
import com.example.demo.repo.SchoolRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepo schoolRepo;

    @Override
    public boolean addSchool(String nameSchool) {
        School school = new School();
        school.setNameSchool(nameSchool);
        schoolRepo.save(school);
        return true;
    }

    @Override
    public boolean removeSchool(Long idSchool) {
        Optional<School> schoolOpt = schoolRepo.findById(idSchool);
        if (schoolOpt.isEmpty()) {
            throw new RuntimeException(String.format("Сущность с id = %s не найдена", idSchool));
        } else schoolRepo.delete(schoolOpt.get());
        return true;
    }
}
