package com.example.backend.websocket;

import java.time.LocalDateTime;

public class UserSession{
    
    private String sessionId;

    private String username;

    private String meetingCode;

    private LocalDateTime connectedAt;

    public UserSession(){

    }

    public UserSession(String sessionId, String username, String meetingCode, LocalDateTime connectedAt) {
        this.sessionId = sessionId;
        this.username = username;
        this.meetingCode = meetingCode;
        this.connectedAt = connectedAt;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMeetingCode() {
        return meetingCode;
    }

    public void setMeetingCode(String meetingCode) {
        this.meetingCode = meetingCode;
    }

    public LocalDateTime getConnectedAt() {
        return connectedAt;
    }

    public void setConnectedAt(LocalDateTime connectedAt) {
        this.connectedAt = connectedAt;
    }

    
}
