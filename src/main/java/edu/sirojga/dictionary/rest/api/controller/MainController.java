package edu.sirojga.dictionary.rest.api.controller;


import edu.sirojga.dictionary.rest.api.MainService.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/test")
    public void test(){
        mainService.addTestUser();
        mainService.addTestUser();
        mainService.test();

    }
}
