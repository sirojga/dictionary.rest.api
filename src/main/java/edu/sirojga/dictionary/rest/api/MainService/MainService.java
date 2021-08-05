package edu.sirojga.dictionary.rest.api.MainService;


import edu.sirojga.dictionary.rest.api.exceptions.NotFoundException;
import edu.sirojga.dictionary.rest.api.model.Dictionary;
import edu.sirojga.dictionary.rest.api.model.DictionaryRecord;
import edu.sirojga.dictionary.rest.api.model.User;
import edu.sirojga.dictionary.rest.api.model.UserDictionaries;
import edu.sirojga.dictionary.rest.api.repository.UserDictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashSet;


@Service
public class MainService {

    @Autowired
    UserDictionaryRepo userDictionaryRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    XlsxParser xlsxParser;

    public void addTestUser(){
        UserDictionaries userDictionaries = new UserDictionaries();
        Dictionary dictionary1 = new Dictionary();
        dictionary1.addRecordToDictionary(new DictionaryRecord("testword","testTranslation"));
        dictionary1.addRecordToDictionary(new DictionaryRecord("testword2","testTranslation2"));
        dictionary1.setLanguagePair("test1test2");
        Dictionary dictionary2 = new Dictionary();
        dictionary2.addRecordToDictionary(new DictionaryRecord("testword3","testTranslation3"));
        dictionary2.addRecordToDictionary(new DictionaryRecord("testword4","testTranslation4"));
        dictionary2.setLanguagePair("test1test3");
        userDictionaries.addDictionary(dictionary1);
        userDictionaries.addDictionary(dictionary2);
        userDictionaries.setUserId("1");
        saveUserDictionary(userDictionaries);

    }

    private UserDictionaries getUserDictionaries(String userId){
        return userDictionaryRepo.findById(userId).orElseThrow(()-> new NotFoundException("Id not found"));
    }

    private void saveUserDictionary (UserDictionaries userDictionaries){
        userDictionaryRepo.save(userDictionaries);
    }

    public UserDictionaries getUserDictionariesByid(String userId){
        return userDictionaryRepo.findById(userId).get();
    }

    public HashSet<Dictionary> getListOfDictionaries(String userId){
        return getUserDictionaries(userId).getDictionaries();
    }

    public void test(){
        Dictionary dictionary1 = new Dictionary();
        dictionary1.addRecordToDictionary(new DictionaryRecord("newtestword","newtestTranslation"));
        dictionary1.addRecordToDictionary(new DictionaryRecord("newtestword2","newtestTranslation2"));
        dictionary1.setLanguagePair("newtest1test2");

        System.out.println(mongoTemplate.updateMulti(new Query(where("_id").is("1")),
                new Update().push("dictionaries", dictionary1),
                UserDictionaries.class));

        System.out.println(mongoTemplate.find(query(where("_id").is("1")), UserDictionaries.class));
        System.out.println(mongoTemplate.getCollectionNames());

    }

    public Dictionary addDictionary(String userId,Dictionary dictionary){
        getUserDictionaries(userId).addDictionary(dictionary);
        return dictionary;
    }

    public void deleteDictionary(String userId, String languagePair){
        UserDictionaries userDictionaries = getUserDictionaries(userId);
        userDictionaries.deleteDictionary(languagePair);
        saveUserDictionary(userDictionaries);

    }

    public Dictionary addWordToDictionary(String userId, String languagePair, DictionaryRecord dictionaryRecord){
        UserDictionaries userDictionaries = getUserDictionaries(userId);
        userDictionaries.getDictionaries().
                stream().
                filter(dictionary -> dictionary.getLanguagePair().equals(languagePair)).
                findFirst().orElseThrow(()-> new NotFoundException(String.format("Dictionary with userId = %s and language pair = %s not found",userId,languagePair))).
                addRecordToDictionary(dictionaryRecord);
        saveUserDictionary(userDictionaries);

        return null;
    }

    }






