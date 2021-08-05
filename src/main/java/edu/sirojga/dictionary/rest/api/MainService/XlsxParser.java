package edu.sirojga.dictionary.rest.api.MainService;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class XlsxParser {

    private Workbook workbook;

    public List<List<String>> xlsxToList(InputStream inputStream) throws IOException {

        workbook=new XSSFWorkbook(inputStream);
        List<List<String>> data = new ArrayList<>();

        for(Sheet sheet : workbook){
            for (Row row : sheet) {
                List<String> record = new ArrayList<>();
                for (Cell cell : row) {
                    record.add(cell.getRichStringCellValue().getString());}
                data.add(record);
            }
        }

        return data;
    }
}

