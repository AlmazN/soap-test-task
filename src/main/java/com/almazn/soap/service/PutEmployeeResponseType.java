package com.almazn.soap.service;


public class PutEmployeeResponseType {
    private int resultCode;
    private String description;

    public PutEmployeeResponseType(int resultCode, String description) {
        this.resultCode = resultCode;
        this.description = description;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
