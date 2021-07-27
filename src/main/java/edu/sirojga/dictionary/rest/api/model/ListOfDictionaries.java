package edu.sirojga.dictionary.rest.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ListOfDictionaries {
    public String language;
    public List<DictionaryRecord> dictionary;

    public ListOfDictionaries(String language, List<DictionaryRecord> dictionary) {
        this.language = language;
        this.dictionary = dictionary;
    }

    public ListOfDictionaries(){}

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<DictionaryRecord> getDictionary() {
        return dictionary;
    }

    public void setDictionary(List<DictionaryRecord> dictionary) {
        this.dictionary = dictionary;
    }
}
