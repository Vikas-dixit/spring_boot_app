package com.dixitdada.journalApp.service;

import com.dixitdada.journalApp.repository.UserRepository;
//import org.apache.catalina.User;
import com.dixitdada.journalApp.entity.User; //

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void  saveEntry(User user)
    {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

public com.dixitdada.journalApp.entity.User findByUserName(String username) {
   return userRepository.findByUsername(username);

}



  }