package com.dixitdada.journalApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection="journalEntry")
@Getter
@Setter
@Data
@NoArgsConstructor
public class journalEntry {



    @Id
    private ObjectId id;

    private String title;

    private LocalDateTime date;
    private String content;
}
