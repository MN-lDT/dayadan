package com.yadanoa.dayadan.entity;

import lombok.Data;

import java.io.Serializable;

/***
 * 最新库存表
 */
@Data
public class Repertory implements Serializable {
    private Integer id;
    private Integer reporteryCount;

}
