package com.example.backend.websocket;

import com.corundumstudio.socketio.SocketIOClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SocketSessionManager {

    private final Map<String, ArrayList<SocketIOClient>> connections =
            new ConcurrentHashMap<>();

    public void joinRoom(String roomId,
                         SocketIOClient client) {

        connections
                .computeIfAbsent(roomId,
                        key -> new ArrayList<>())
                .add(client);

    }

    public ArrayList<SocketIOClient> getParticipants(
            String roomId) {

        return connections.getOrDefault(
                roomId,
                new ArrayList<>());

    }

}