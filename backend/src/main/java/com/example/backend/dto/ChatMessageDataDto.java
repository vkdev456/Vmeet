package com.example.backend.dto;

public class ChatMessageDataDto {

    private String data;
    private String sender;

    public ChatMessageDataDto() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}