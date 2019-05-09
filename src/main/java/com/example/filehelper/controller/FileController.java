package com.example.filehelper.controller;


import com.example.filehelper.dto.DataFile;
import com.example.filehelper.dto.FileType;
import com.example.filehelper.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping
    public void fileGenerate(){
        DataFile dataFile = DataFile.builder()
                .name("20191212_123")
                .localDate(LocalDate.now())
                .accountNumber("123")
                .fileType(FileType.PDF)
                .build();

        fileService.createPath(dataFile);
        fileService.rename(dataFile);


    }

}
