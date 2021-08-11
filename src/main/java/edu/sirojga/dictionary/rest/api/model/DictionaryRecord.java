package edu.sirojga.dictionary.rest.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class DictionaryRecord {

    @Id
    private String id;
    private String word;
    private String translation;
    private String picture;
    private Boolean isLearned = false;

    public DictionaryRecord() {
    }

    public DictionaryRecord(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public DictionaryRecord(String word, String translation, String picture) {
        this.word = word;
        this.translation = translation;
        this.picture=picture;
    }

    public void setPicture(String base64Picture){
        this.picture=base64Picture;
    }

    public String getPicture(){
      return this.picture;
    }

    public void setLearned(){
        isLearned=true;
    }

    public void setUnlearned(){
        isLearned=false;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Boolean getLearned() {
        return isLearned;
    }

    public void setLearned(Boolean learned) {
        isLearned = learned;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DictionaryRecord{" +
                "word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                ", picture='" + picture + '\'' +
                ", isLearned=" + isLearned +
                '}';
    }
}
