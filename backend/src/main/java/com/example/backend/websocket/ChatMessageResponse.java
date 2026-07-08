package com.example.backend.websocket;

public class ChatMessageResponse {

    private String event;

    private ChatMessage message;

    public ChatMessageResponse(){
        
    }

    public ChatMessageResponse(String event, ChatMessage message) {
        this.event = event;
        this.message = message;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }
}