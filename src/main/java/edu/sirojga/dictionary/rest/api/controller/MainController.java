package edu.sirojga.dictionary.rest.api.controller;


import edu.sirojga.dictionary.rest.api.MainService.DictionaryService;
import edu.sirojga.dictionary.rest.api.model.Dictionary;
import edu.sirojga.dictionary.rest.api.model.DictionaryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MainController {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/test")
    public void test(){
        dictionaryService.addTestUser();
        dictionaryService.addWordToDictionary("1","test1test2",new DictionaryRecord("getteset1","getTest2"));
    }
}
