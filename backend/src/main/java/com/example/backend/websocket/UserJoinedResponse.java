package com.example.backend.websocket;

import java.util.List;

public class UserJoinedResponse {

    private String event;
    private String sessionId;
    private List<String> participants;

    public UserJoinedResponse() {
    }

    public UserJoinedResponse(String event, String sessionId, List<String> participants) {
        this.event = event;
        this.sessionId = sessionId;
        this.participants = participants;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }
}