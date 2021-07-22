package com.example.demo.mapper;

import com.example.demo.dto.RatingInDto;
import com.example.demo.dto.RatingOutDto;
import com.example.demo.entity.Journal;
import com.example.demo.entity.Person;
import com.example.demo.entity.Rating;
import com.example.demo.repo.JournalRepo;
import com.example.demo.repo.PersonRepo;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RatingMapper {

    private final JournalRepo journalRepo;
    private final PersonRepo personRepo;

    public RatingOutDto entityToOutDto(Rating rating) {
        if (rating != null) {
            return new RatingOutDto(rating.getId(), rating.getMark(), rating.getLocalDate(), rating.getPerson().getId(), rating.getJournal().getId());
        }return null;
    }

    public Rating inDtoToEntity(RatingInDto ratingInDto) {
        Rating rating = new Rating(ratingInDto.getMark(), ratingInDto.getLocalDate());
        if(ratingInDto.getIdJournal() != null) {
            Optional<Journal> journalOpt = journalRepo.findById(ratingInDto.getIdJournal());
            if(journalOpt.isEmpty()){
                throw new RuntimeException(String.format("Сущность с id=%s не найдена",ratingInDto.getIdJournal()));
            }  else {
                Journal journal = journalOpt.get();
                rating.setJournal(journal);
            }
        }else return null;
        if (ratingInDto.getIdPersons() != null) {
            Optional<Person> personOpt = personRepo.findById(ratingInDto.getIdPersons());
            if(personOpt.isEmpty()){
                throw new RuntimeException(String.format("Сущность с id=%s не найдена",ratingInDto.getIdPersons()));
            }  else {
                Person person = personOpt.get();
                rating.setPerson(person);
            }
        }else return null;
        return null;
}
}
