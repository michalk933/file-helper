package com.example.filehelper.service;

import com.example.filehelper.dto.DataFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    public void createPath(DataFile dataFile) {
        Path pathToFile = Paths.get(dataFile.getFullpathWithoutFile() + dataFile.getNameLck());
        try {
            Files.createDirectories(pathToFile.getParent());
            Files.createFile(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rename(DataFile dataFile) {
        File fileLck = new File(dataFile.getFullpathWithoutFile() + dataFile.getNameLck());
        File fileNew = new File(dataFile.getFullpathWithoutFile() + dataFile.getNameWithType());
        fileLck.renameTo(fileNew);
    }


}
