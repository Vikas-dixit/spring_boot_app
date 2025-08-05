package com.dixitdada.journalApp.service;

import com.dixitdada.journalApp.entity.User;
import com.dixitdada.journalApp.entity.journalEntry;
import com.dixitdada.journalApp.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class journalEntryService {

    @Autowired
    private  journalEntryRepository jjournalEntryRepository;

   @Autowired
   private UserService userservice;

    public void  saveEntry(journalEntry JournalEntry,String username)
    {  User user=userservice.findByUserName(username);

        journalEntry.setDate(localDateTime.now());
        jjournalEntryRepository.save(JournalEntry);
    }

    public List<journalEntry>getAll() {
        return jjournalEntryRepository.findAll();
    }

    public Optional<journalEntry> findById(ObjectId id) {
        return jjournalEntryRepository.findById(id);
    }

public void deleteById(ObjectId id){
    jjournalEntryRepository.deleteById(id);
}
  }