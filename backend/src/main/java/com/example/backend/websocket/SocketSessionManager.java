package com.example.backend.websocket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class SocketSessionManager {

    private final Map<String, List<String>> connections = new ConcurrentHashMap<>();

    private final Map<String, List<ChatMessage>> messages = new ConcurrentHashMap<>();

    private final Map<String, LocalDateTime> timeOnline = new ConcurrentHashMap<>();

    public void addConnection(String roomId, String sessionId) {

        connections.computeIfAbsent(roomId, key -> new ArrayList<>())
                .add(sessionId);

    } 

    public List<String> getConnections(String roomId) {

        return connections.getOrDefault(roomId, new ArrayList<>());

    }

    public void saveConnectionTime(String sessionId) {

        timeOnline.put(sessionId, LocalDateTime.now());

    }

    public LocalDateTime getConnectionTime(String sessionId) {

        return timeOnline.get(sessionId);

    }

    public void removeConnectionTime(String sessionId) {

        timeOnline.remove(sessionId);

    }

    public void addMessage(String roomId, ChatMessage message) {

        messages.computeIfAbsent(roomId, key -> new ArrayList<>())
                .add(message);

    }

    public List<ChatMessage> getMessages(String roomId) {

        return messages.getOrDefault(roomId, new ArrayList<>());

    }

}
