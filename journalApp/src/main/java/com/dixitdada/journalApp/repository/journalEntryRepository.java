package com.dixitdada.journalApp.repository;

import com.dixitdada.journalApp.entity.journalEntry;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepository extends MongoRepository<journalEntry, ObjectId> {


}
