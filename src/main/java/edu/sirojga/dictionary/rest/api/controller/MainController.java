package edu.sirojga.dictionary.rest.api.controller;

import edu.sirojga.dictionary.rest.api.MainService.XlsxParser;
import edu.sirojga.dictionary.rest.api.model.DictionaryRecord;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class MainController {
    List<List<String>> list = new ArrayList<>();

    @PostMapping("/r")
    public List<List<String>> uploadDictionaryFromXlsx(@RequestParam("file") MultipartFile MultipartFile) throws IOException {

            list=new XlsxParser(MultipartFile.getInputStream()).xlsxToList();


        return list;
    }

    @GetMapping("/r")
    public  List<List<String>> getRecord(){

        for(List<String> arr: list ){
            System.out.println(arr);

        }
        return list;
    }

}
