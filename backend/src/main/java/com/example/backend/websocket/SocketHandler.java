package com.example.backend.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.util.*;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
public class SocketHandler extends TextWebSocketHandler {

    private final SocketSessionManager sessionManager;
    // private final ObjectMapper objectMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        sessionManager.addSession(session);

        System.out.println("CONNECTED : " + session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session,
            TextMessage message) throws Exception {

        SocketEvent event = objectMapper.readValue(message.getPayload(), SocketEvent.class);

        switch (event.getEvent()) {

            case "join-call":
                joinCall(session, event);
                break;

            default:
                System.out.println("Unknown Event : " + event.getEvent());

        }

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
            CloseStatus status) {

        sessionManager.removeSession(session.getId());

        sessionManager.removeConnectionTime(session.getId());

        System.out.println("DISCONNECTED : " + session.getId());

    }

    private void joinCall(WebSocketSession session,
            SocketEvent event) throws Exception {

        // Store participant in the room
        sessionManager.addConnection(
                event.getRoomId(),
                session.getId());

        // Save connection time
        sessionManager.saveConnectionTime(session.getId());

        // Get everyone in the room
        List<String> participants = sessionManager.getConnections(event.getRoomId());

        // Notify everyone
        UserJoinedResponse response = new UserJoinedResponse(
                "user-joined",
                session.getId(),
                participants);

        for (String participantId : participants) {

            WebSocketSession participant = sessionManager.getSession(participantId);

            if (participant != null && participant.isOpen()) {

                sendMessage(participant, response);

            }
        }

        System.out.println(session.getId() + " joined room " + event.getRoomId());

    }

    private void sendMessage(WebSocketSession session, Object message) throws Exception {

        String json = objectMapper.writeValueAsString(message);

        session.sendMessage(new TextMessage(json));

    }

}