package edu.sirojga.dictionary.rest.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Document
public class UserDictionaries {
    @Id
    String userId;
    HashSet<Dictionary> dictionaries;

    public UserDictionaries() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public HashSet<Dictionary> getDictionaries() {
        return dictionaries;
    }

    public void addDictionary(Dictionary dictionary) {
        if(this.dictionaries==null){
            this.dictionaries = new HashSet<>();
        }

        this.dictionaries.add(dictionary) ;
    }
}
