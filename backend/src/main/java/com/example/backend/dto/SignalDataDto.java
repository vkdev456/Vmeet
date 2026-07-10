package com.example.backend.dto;

public class SignalDataDto {

    private String toId;
    private Object message;

    public SignalDataDto() {
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}