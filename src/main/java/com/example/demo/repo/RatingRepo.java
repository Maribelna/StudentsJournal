package com.example.demo.repo;

import com.example.demo.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,Long> {
    @Query(value = "select rt from Rating rt where rt.student.id =:idStudent")
    List<Rating> findAllByPerson(@Param("idStudent") Long idStudent);
    
    

}
