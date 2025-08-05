package com.dixitdada.journalApp.repository;


//import org.apache.catalina.User;
import com.dixitdada.journalApp.entity.User; //


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    com.dixitdada.journalApp.entity.User findByUsername(String username);
}

