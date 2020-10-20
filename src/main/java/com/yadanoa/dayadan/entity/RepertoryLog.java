package com.yadanoa.dayadan.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RepertoryLog implements Serializable {
    private Integer id;
    private Integer user_id;
    private String type;
    private Integer addCount;
    private Integer cutKdCount;
    private Integer cutQpCount;
    private Date createDate;
    private Integer repertoryNum;

}
