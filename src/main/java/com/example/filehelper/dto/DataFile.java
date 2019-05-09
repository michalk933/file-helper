package com.example.filehelper.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DataFile {

    private String name;

    private LocalDate localDate;

    private String accountNumber;

    private FileType fileType;


    private final static String path = "/Users/michalkuchciak/IdeaProjects/file-helper";

    private final static String patterFile = "/%1$s/%2$s/%3$s/%4$s/";

    public String getFullpathWithoutFile(){
        PathHelper pathHelper = this.getPathHelper(this.localDate, this.accountNumber);
        return path + String.format(patterFile, pathHelper.getYear(), pathHelper.getMonth(), pathHelper.getDay(), pathHelper.getNumber());
    }

    public String getNameLck(){
        return String.format("%1$s.LCK", this.name);
    }

    public String getNameWithType(){
        return String.format("%1$s.%2$s", this.name, this.fileType);
    }

    private PathHelper getPathHelper(LocalDate localDate, String accountNumber){
        return PathHelper.builder()
                .year(String.valueOf(localDate.getYear()))
                .month(String.valueOf(localDate.getMonthValue()))
                .day(String.valueOf(localDate.getDayOfMonth()))
                .number(accountNumber)
                .build();
    }

}
