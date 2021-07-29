package com.example.demo.service;

public interface JournalService {
    boolean addJournal(String nameLesson, Long idClass);

    boolean removeJournal(Long idJournal);
}
