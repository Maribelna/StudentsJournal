package com.example.demo.service;

import com.example.demo.DateTimeUtils;
import com.example.demo.dto.RatingInDto;
import com.example.demo.dto.RatingOutDto;
import com.example.demo.entity.Rating;
import com.example.demo.mapper.RatingMapper;
import com.example.demo.repo.RatingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepo ratingRepo;
    private final RatingMapper ratingMapper;

    @Override
    public List<RatingOutDto> getRatingPerson(Long idPerson) {
        List<Rating> ratingList= ratingRepo.findAllByPerson(idPerson);
        List<RatingOutDto> ratingOutDtoList = new ArrayList<>();
        for(Rating rating: ratingList){
            ratingOutDtoList.add(ratingMapper.entityToOutDto(rating));
        }
        return ratingOutDtoList;
    }
    @Override
    public boolean saveRating(Integer mark, String date, Long idPerson, Long idJournal){
        LocalDate localDate = DateTimeUtils.strToLocalDate(date);
        RatingInDto ratingInDto = new RatingInDto(mark,localDate,idPerson,idJournal);
        Rating rating = ratingMapper.inDtoToEntity(ratingInDto);
        ratingRepo.save(rating);
        return true;
    }
}
