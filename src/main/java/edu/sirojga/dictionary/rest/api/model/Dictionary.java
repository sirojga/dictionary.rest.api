package edu.sirojga.dictionary.rest.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Dictionary {
    public String languagePair;
    public ArrayList<DictionaryRecord> records;

    public Dictionary(String language, ArrayList<DictionaryRecord> records) {
        this.languagePair = language;
        this.records = records;
    }

    public Dictionary(){
        records=new ArrayList<>();
    }

    public String getLanguagePair() {
        return languagePair;
    }

    public void addRecordToDictionary(DictionaryRecord dictionaryRecord) {
        records.add(dictionaryRecord);
    }

    public void setLanguagePair(String language) {
        this.languagePair = language;
    }

    public List<DictionaryRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<DictionaryRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "ListOfDictionaries{" +
                "language='" + languagePair + '\'' +
                ", dictionary=" + records +
                '}';
    }
}
