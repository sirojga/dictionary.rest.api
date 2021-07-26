package edu.sirojga.dictionary.rest.api.model;

import java.util.List;

public class DictionaryRecord {

    final String word;
    final String translation;
    Boolean isLearned = false;

    public DictionaryRecord(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public List<String> getRecord(){
        return List.of(word,translation);
    }

    public void setLearned(){
        isLearned=true;
    }

    public void setUnlearned(){
        isLearned=false;
    }
}
