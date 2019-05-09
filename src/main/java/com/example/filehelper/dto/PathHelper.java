package com.example.filehelper.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PathHelper {

    private String year;

    private String month;

    private String day;

    private String number;

}
