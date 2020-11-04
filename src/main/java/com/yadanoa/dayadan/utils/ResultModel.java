package com.yadanoa.dayadan.utils;

import java.io.Serializable;


public class ResultModel<T> implements Serializable {

    private Boolean result;

    private String message;

    private T returnValue;

    public static <T> ResultModel<T> setSuccess(T data) {
        ResultModel<T> result = new ResultModel<>();
        result.setResult(true);
        result.setReturnValue(data);
        return result;
    }

    public static ResultModel setFail(String message) {
        ResultModel result = new ResultModel<>();
        result.setResult(false);
        result.setMessage(message);
        return result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(T returnValue) {
        this.returnValue = returnValue;
    }
}
