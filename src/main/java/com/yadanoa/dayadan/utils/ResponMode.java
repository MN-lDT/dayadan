package com.yadanoa.dayadan.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class ResponMode implements Serializable {
    private Boolean flag;
    private String msg ;
    private Object data;
}
