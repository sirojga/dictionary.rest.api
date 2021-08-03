package edu.sirojga.dictionary.rest.api.MainService;


import edu.sirojga.dictionary.rest.api.exceptions.NotFoundException;
import edu.sirojga.dictionary.rest.api.model.Dictionary;
import edu.sirojga.dictionary.rest.api.model.DictionaryRecord;
import edu.sirojga.dictionary.rest.api.model.UserDictionaries;
import edu.sirojga.dictionary.rest.api.repository.UserDictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;


@Service
public class DictionaryService {



    @Autowired
    UserDictionaryRepo userDictionaryRepo;

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

    public HashSet<Dictionary> getListOfDictionaries(String userId){
        return getUserDictionaries(userId).getDictionaries();
    }

    public Dictionary addDictionaryToUser(String userId,Dictionary dictionary){
        getUserDictionaries(userId).addDictionary(dictionary);
        return dictionary;
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






