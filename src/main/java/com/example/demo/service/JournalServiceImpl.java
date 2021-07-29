package com.example.demo.service;

import com.example.demo.entity.ClassSchool;
import com.example.demo.entity.Journal;
import com.example.demo.repo.ClassSchoolRepo;
import com.example.demo.repo.JournalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final ClassSchoolRepo classSchoolRepo;
    private final JournalRepo journalRepo;

    @Override
    public boolean addJournal(String nameLesson, Long idClass) {
        Optional<ClassSchool> classSchoolOpt = classSchoolRepo.findById(idClass);
        if (classSchoolOpt.isEmpty()) {
            throw new RuntimeException(String.format("Сущность с id = %s не найдена", idClass));
        } else {
            Journal journal = new Journal(nameLesson, classSchoolOpt.get());
            journalRepo.save(journal);
        }
        return true;
    }

    @Override
    public boolean removeJournal(Long idJournal) {
        Optional<Journal> journalOpt = journalRepo.findById(idJournal);
        if (journalOpt.isEmpty()) {
            throw new RuntimeException(String.format("Сущность с id = %s не найдена", idJournal));
        } else journalRepo.delete(journalOpt.get());
        return true;
    }
}
