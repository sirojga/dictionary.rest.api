package edu.sirojga.dictionary.rest.api.MainService;


import com.mongodb.BasicDBObject;
import edu.sirojga.dictionary.rest.api.model.Dictionary;
import edu.sirojga.dictionary.rest.api.model.DictionaryRecord;
import edu.sirojga.dictionary.rest.api.model.User;
import edu.sirojga.dictionary.rest.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@Service
public class MainService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    XlsxParser xlsxParser;

    public void addTestUser(){

        Dictionary dictionary1 = new Dictionary();
        dictionary1.addRecordToDictionary(new DictionaryRecord("testword","testTranslation"));
        dictionary1.addRecordToDictionary(new DictionaryRecord("testword2","testTranslation2"));
        dictionary1.setLanguagePair("test1test2");
        Dictionary dictionary2 = new Dictionary();
        dictionary2.addRecordToDictionary(new DictionaryRecord("testword3","testTranslation3"));
        dictionary2.addRecordToDictionary(new DictionaryRecord("testword4","testTranslation4"));
        dictionary2.setLanguagePair("test1test3");

        User user=new User("test@email.com","testpass","true");
        user.addDictionariy(dictionary1);
        user.addDictionariy(dictionary2);
        userRepo.save(user);

    }


    public void test(){
        //Dictionary dictionary1 = new Dictionary();
       // dictionary1.addRecordToDictionary(new DictionaryRecord("new word","new word"));
       // dictionary1.addRecordToDictionary(new DictionaryRecord("new word1","new word1"));
      //  dictionary1.setLanguagePair("test1test2");

//        System.out.println(mongoTemplate.updateFirst(new Query(where("dictionaries").elemMatch(Criteria.where("languagePair").is("test1test3")).and("_id").is("1")),
//                new Update().push("dictionaries.$.records", new DictionaryRecord("criteria","criteria")),
//                UserDictionaries.class));

        //System.out.println(mongoTemplate.find(query(where("_id").is("1").and("dictionaries.languagePair").is("test1test3")), UserDictionaries.class));
       // System.out.println(mongoTemplate.getCollectionNames());

        //mongoTemplate.remove(new Query(where("dictionaries").elemMatch(Criteria.where("languagePair").is("test1test3")).and("_id").is("1")), UserDictionaries.class);
//        Update update =
//                new Update().pull("dictionaries",
//                        new BasicDBObject("languagePair", "test1test3"));
//        mongoTemplate.updateMulti(new Query(where("_id").is("1")), update, UserDictionaries.class);
    }






    }






