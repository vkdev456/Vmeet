package com.example.backend.websocket;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class SocketSessionManager{
    
    private final Map<String, UserSession>sessions=new ConcurrentHashMap<>();

    public void RegisterSeesion(UserSession session){
        sessions.put(session.getSessionId(),session);

    }

    public void removeSession(String sessionId){
        sessions.remove(sessionId);
    }

    public UserSession getSession(String sessionId){
        return sessions.get(sessionId);
    }

    public boolean contains(String sessionId) {
      return sessions.containsKey(sessionId);
    }

    public List<UserSession> getUserByMeeting(String meetingCode){

        return sessions.values()
                       .stream().filter(session->meetingCode.equals(session.getMeetingCode())).toList();
    }

    
    
}
