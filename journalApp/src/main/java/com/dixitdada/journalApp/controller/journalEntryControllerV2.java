package com.dixitdada.journalApp.controller;

import com.dixitdada.journalApp.entity.User;
import com.dixitdada.journalApp.entity.journalEntry;
import com.dixitdada.journalApp.service.UserService;
import com.dixitdada.journalApp.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {


    @Autowired
    private journalEntryService JEntryService;

    @Autowired
    public UserService userservice;



    @GetMapping
    public List<journalEntry>get(){
       return JEntryService.getAll();



    }

    @PostMapping
    public ResponseEntity<journalEntry> createEntry(@RequestBody journalEntry myEntry) {

        try {
            myEntry.setDate(LocalDateTime.now());

            JEntryService.saveEntry(myEntry);

            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("id/{myId}")
    //
    public boolean deletejournalEntryById(@PathVariable ObjectId myId){
         JEntryService.deleteById(myId);
         return true;
    }


    @GetMapping("{username}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String username) {
        User user = userservice.findByUserName(username);
        List<journalEntry> all = user.getJournalEntries();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);

        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);

    }

     @PutMapping("id/{myId}")
     public journalEntry updatejournalById(@PathVariable ObjectId Id,@RequestBody journalEntry newEntry){

         journalEntry old= JEntryService.findById(Id).orElse(null);
         if(old!=null){
             old.setTitle(newEntry.getTitle()!=null &&!newEntry.getTitle().equals("")? newEntry.getTitle(): old.getTitle());
              old.setContent(newEntry.getContent()!=null &&newEntry.equals("")? newEntry.getContent() : old.getContent());
         }
         JEntryService.saveEntry(old);
         return old;

   }
 //  @DeleteMapping("id/{myId}")
    //public ResponseEntity <?> deleteJournalEntryById(@PathVariable ObjectId myId){
 //       journalEntryService.deleteById(myId);

}
