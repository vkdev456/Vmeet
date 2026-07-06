package com.example.backend.websocket;

public class SocketEvent {

    private String event;

    private String roomId;

    private String sender;

    private String target;

    private String data;

    public SocketEvent() {
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}