package com.example.backend.websocket;

public class ChatMessage {

    private String sender;
    private String data;
    private String socketIdSender;

    public ChatMessage() {
    }

    public ChatMessage(String sender, String data, String socketIdSender) {
        this.sender = sender;
        this.data = data;
        this.socketIdSender = socketIdSender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSocketIdSender() {
        return socketIdSender;
    }

    public void setSocketIdSender(String socketIdSender) {
        this.socketIdSender = socketIdSender;
    }
}