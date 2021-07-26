package edu.sirojga.dictionary.rest.api.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class UserDictionary {
    @Id
    String userId;
    List<ListOfDictionaries> dictionaries;

    public UserDictionary(String userId, List<ListOfDictionaries> dictionaries) {
        this.userId = userId;
        this.dictionaries = dictionaries;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ListOfDictionaries> getDictionaries() {
        return dictionaries;
    }

    public void setDictionaries(List<ListOfDictionaries> dictionaries) {
        this.dictionaries = dictionaries;
    }
}
