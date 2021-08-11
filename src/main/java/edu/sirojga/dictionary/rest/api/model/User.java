package edu.sirojga.dictionary.rest.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Document
public class User {

    @Id
    String id;
    String email;
    String password;
    HashSet<Dictionary> dictionaries;
    String isActive;


    public User( String email, String password, String isActive) {
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.dictionaries=new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public HashSet<Dictionary> getDictionaries() {
        return dictionaries;
    }

    public void setDictionaries(HashSet<Dictionary> dictionaries) {
        this.dictionaries = dictionaries;
    }

    public void addDictionariy(Dictionary dictionary) {
        this.dictionaries.add(dictionary);
    }
}
