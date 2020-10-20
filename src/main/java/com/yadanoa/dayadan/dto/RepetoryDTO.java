package com.yadanoa.dayadan.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RepetoryDTO {
    private Date createDate;
    private String name;
    private String repetoryCount;
    private String addCount;
    private String cutKdCount;
    private String cutQpCount;
    private String type;

}
