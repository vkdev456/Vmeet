package com.example.backend.websocket;

import com.corundumstudio.socketio.SocketIOClient;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SocketSessionManager {

        private final Map<String, ArrayList<String>> connections = new ConcurrentHashMap<>();

        private final Map<String, ArrayList<ChatMessage>> messages = new ConcurrentHashMap<>();

        private final Map<String, LocalDateTime> timeOnline = new ConcurrentHashMap<>();

        private final Map<String, SocketIOClient> sessions = new ConcurrentHashMap<>();

        public void addClient(SocketIOClient client) {
                sessions.put(client.getSessionId().toString(), client);
        }

        public SocketIOClient getClient(String sessionId) {
                return sessions.get(sessionId);
        }

        public void removeClient(String sessionId) {
                sessions.remove(sessionId);
        }

        public void joinRoom(String roomId, SocketIOClient client) {
                connections.computeIfAbsent(roomId, key -> new ArrayList<>())
                                .add(client.getSessionId().toString());
        }

        public ArrayList<String> getParticipants(String roomId) {
                return connections.getOrDefault(roomId, new ArrayList<>());
        }

        public Map<String, ArrayList<String>> getConnections() {
                return connections;
        }

        public Map<String, ArrayList<ChatMessage>> getMessages() {
                return messages;
        }

        public Map<String, LocalDateTime> getTimeOnline() {
                return timeOnline;
        }

        public void addConnectionTime(String sessionId) {
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

        public ArrayList<ChatMessage> getRoomMessages(String roomId) {
                return messages.getOrDefault(roomId, new ArrayList<>());
        }

        public String findRoomBySessionId(String sessionId) {

                for (Map.Entry<String, ArrayList<String>> entry : connections.entrySet()) {
                        if (entry.getValue().contains(sessionId)) {
                                return entry.getKey();
                        }
                }
                return null;
        }

        public void removeParticipant(String roomId, String sessionId){
                ArrayList<String> participants = connections.get(roomId);
                if (participants != null){
                        participants.remove(sessionId);
                        if (participants.isEmpty()) {
                                connections.remove(roomId);
                        }
                }
        }

}