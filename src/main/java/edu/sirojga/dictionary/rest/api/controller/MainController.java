package edu.sirojga.dictionary.rest.api.controller;


import edu.sirojga.dictionary.rest.api.MainService.MainService;
import edu.sirojga.dictionary.rest.api.model.UserDictionaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/test")
    public UserDictionaries test(){
        mainService.test();
        return mainService.getUserDictionariesByid("1");
        //dictionaryService.addWordToDictionary("1","test1test2",new DictionaryRecord("getteset1","getTest2"));
        //dictionaryService.deleteDictonary("1","test1test2");
    }
}
