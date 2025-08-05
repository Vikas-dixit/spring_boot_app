package com.dixitdada.journalApp.controller;

import com.dixitdada.journalApp.entity.journalEntry;
import com.dixitdada.journalApp.service.UserService;
import com.dixitdada.journalApp.service.journalEntryService;
//import org.apache.catalina.User;
  import com.dixitdada.journalApp.entity.User;



//import com.dixitdada.journalApp.entity.user;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserControllerV2 {


    @Autowired
    private UserService userservice;

    @GetMapping
    public List<User> getAllUsers() {

        return userservice.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {

        userservice.saveEntry(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
     //public ResponseEntity<?> updateUser(@RequestBody com.dixitdada.journalApp.entity.user user) {
        User userInDb = userservice.findByUserName(user.getUsername());
       // com.dixitdada.journalApp.entity.user userInDb = userservice.findByUserName(user.getUsername());
        if (userInDb != null) {
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userservice.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}






