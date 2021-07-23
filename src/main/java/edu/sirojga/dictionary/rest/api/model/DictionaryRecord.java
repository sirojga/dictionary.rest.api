package edu.sirojga.dictionary.rest.api.model;

import java.util.List;

public class DictionaryRecord {

    final String sourceLanguage;
    final String translateLanguage;
    final String word;
    final String translation;

    public DictionaryRecord(String sourceLanguage, String translateLanguage, String word, String translation) {
        this.sourceLanguage = sourceLanguage;
        this.translateLanguage = translateLanguage;
        this.word = word;
        this.translation = translation;
    }

    public List<String> getRecord(){
        return List.of(sourceLanguage,translateLanguage,word,translation);
    }
}
