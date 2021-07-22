package com.example.demo.repo;

import com.example.demo.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepo extends JpaRepository<Journal,Long> {
}
