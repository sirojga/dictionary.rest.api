package edu.sirojga.dictionary.rest.api.controller;

import edu.sirojga.dictionary.rest.api.MainService.XlsxParser;
import edu.sirojga.dictionary.rest.api.model.DictionaryRecord;
import edu.sirojga.dictionary.rest.api.model.ListOfDictionaries;
import edu.sirojga.dictionary.rest.api.model.User;
import edu.sirojga.dictionary.rest.api.model.UserDictionary;
import edu.sirojga.dictionary.rest.api.repository.UserDictionaryRepo;
import edu.sirojga.dictionary.rest.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.*;

@RestController

public class MainController {

    @Autowired
    private UserRepo repository1;

    @Autowired
    private UserDictionaryRepo repository2;
    ListOfDictionaries listOfDictionaries =new ListOfDictionaries();



    List<List<String>> list = new ArrayList<>();
    DictionaryRecord record;

    @GetMapping("/new")
    public User addUser(@RequestParam("id") String id
                        )  {
        User user=repository1.findById(id).get();
        listOfDictionaries.language="puksrenik";
        listOfDictionaries.dictionary=List.of(new DictionaryRecord("test1","test2"),new DictionaryRecord("test2","test3"));
        repository2.save(new UserDictionary(user.getId(),List.of(listOfDictionaries)));
        return user;
    }



    @GetMapping("/get")
    public Optional<User> getUserById(@RequestParam("id") String id){
        return repository1.findById(id);

    }

    @GetMapping("/getr")
    public Optional<User> saved(@RequestParam("id") String id){

        return repository1.findById(id);

    }

    @PostMapping("/r")
    public List<List<String>> uploadDictionaryFromXlsx(@RequestParam("file") MultipartFile MultipartFile) throws IOException {

            list.addAll(new XlsxParser(MultipartFile.getInputStream()).xlsxToList());

        return list;
    }

    @PostMapping("/re")
    public List<String> uploadRecord( @RequestParam String sourceLanguage,
                                      @RequestParam String translateLanguage,
                                      @RequestParam String word,
                                      @RequestParam String translation)  {

        record= new DictionaryRecord(word,translation);
        list.add(record.getRecord());

        return record.getRecord();
    }

    @GetMapping("/r")
    public  List<List<String>> getRecord(){

        for(List<String> arr: list ){
            System.out.println(arr);
        }
        return list;
    }

}
