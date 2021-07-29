package com.example.demo.mapper;

import com.example.demo.dto.RatingInDto;
import com.example.demo.dto.RatingOutDto;
import com.example.demo.entity.Journal;
import com.example.demo.entity.Rating;
import com.example.demo.entity.Student;
import com.example.demo.repo.JournalRepo;
import com.example.demo.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class RatingMapper {

    private final JournalRepo journalRepo;
    private final StudentRepo studentRepo;

    public RatingOutDto entityToOutDto(Rating rating) {
            return new RatingOutDto(rating.getId(), rating.getMark(), rating.getLocalDate(), rating.getStudent().getId(), rating.getJournal().getId());
    }

    public Rating inDtoToEntity(RatingInDto ratingInDto) {
        Rating rating = new Rating(ratingInDto.getMark(), ratingInDto.getLocalDate());
        if(ratingInDto.getIdJournals() != null) {
            Optional<Journal> journalOpt = journalRepo.findById(ratingInDto.getIdJournals());
            if(journalOpt.isEmpty()){
                throw new RuntimeException(String.format("Сущность с id=%s не найдена",ratingInDto.getIdJournals()));
            }  else {
                Journal journal = journalOpt.get();
                rating.setJournal(journal);
            }
        }else rating.setJournal(null);
        if (ratingInDto.getIdStudents() != null) {
            Optional<Student> studentOpt = studentRepo.findById(ratingInDto.getIdStudents());
            if(studentOpt.isEmpty()){
                throw new RuntimeException(String.format("Сущность с id=%s не найдена",ratingInDto.getIdStudents()));
            }  else {
                rating.setStudent(studentOpt.get());
            }
        }else rating.setStudent(null);
        return rating;
}
}
