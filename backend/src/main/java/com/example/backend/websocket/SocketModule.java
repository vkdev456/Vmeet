package com.example.backend.websocket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.backend.dto.ChatMessageDataDto;
import com.example.backend.dto.JoinCallDataDto;
import com.example.backend.dto.SignalDataDto;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class SocketModule {

    private final SocketIOServer server;
    private final SocketSessionManager sessionManager;

    @PostConstruct
    public void init() {

        server.addConnectListener(client -> {

            sessionManager.addClient(client);

            System.out.println("CONNECTED : " + client.getSessionId());

        });

        server.addEventListener(
                "join-call",
                JoinCallDataDto.class,
                (client, data, ackSender) -> {

                    String sessionId = client.getSessionId().toString();

                    sessionManager.joinRoom(
                            data.getPath(),
                            client);

                    sessionManager.addConnectionTime(sessionId);

                    ArrayList<String> participants = sessionManager.getParticipants(data.getPath());

                    for (String participantId : participants) {

                        SocketIOClient participant = sessionManager.getClient(participantId);

                        if (participant != null && participant.isChannelOpen()) {

                            participant.sendEvent(
                                    "user-joined",
                                    sessionId,
                                    participants);
                        }

                    }

                    ArrayList<ChatMessage> roomMessages = sessionManager.getRoomMessages(data.getPath());

                    for (ChatMessage message : roomMessages) {

                        client.sendEvent(
                                "chat-message",
                                message.getData(),
                                message.getSender(),
                                message.getSocketIdSender());

                    }

                    System.out.println(
                            sessionId + " joined " + data.getPath());

                });

        server.addEventListener(
                "signal",
                SignalDataDto.class,
                (client, data, ackSender) -> {

                    SocketIOClient targetClient = sessionManager.getClient(data.getToId());

                    if (targetClient != null && targetClient.isChannelOpen()) {

                        targetClient.sendEvent(
                                "signal",
                                client.getSessionId().toString(),
                                data.getMessage());

                    }

                });

        server.addEventListener(
                "chat-message",
                ChatMessageDataDto.class,
                (client, data, ackSender) -> {

                    String sessionId = client.getSessionId().toString();

                    String roomId = sessionManager.findRoomBySessionId(sessionId);

                    if (roomId == null) {
                        return;
                    }

                    ChatMessage message = new ChatMessage(
                            data.getSender(),
                            data.getData(),
                            sessionId);

                    sessionManager.addMessage(roomId, message);

                    System.out.println(
                            "message " + roomId + " : "
                                    + data.getSender()
                                    + " "
                                    + data.getData());

                    ArrayList<String> participants = sessionManager.getParticipants(roomId);

                    for (String participantId : participants) {

                        SocketIOClient participant = sessionManager.getClient(participantId);

                        if (participant != null && participant.isChannelOpen()) {

                            participant.sendEvent(
                                    "chat-message",
                                    data.getData(),
                                    data.getSender(),
                                    sessionId);

                        }

                    }

                });
        server.addDisconnectListener(client -> {

            String sessionId = client.getSessionId().toString();
            String roomId = sessionManager.findRoomBySessionId(sessionId);
            if (roomId != null) {

                sessionManager.removeParticipant(roomId, sessionId);
                ArrayList<String> participants = new ArrayList<>(sessionManager.getParticipants(roomId));
                for (String participantId : participants) {
                    SocketIOClient participant = sessionManager.getClient(participantId);
                    if (participant != null && participant.isChannelOpen()) {
                        participant.sendEvent(
                                "user-left",
                                sessionId);
                    }
                }
            }

            sessionManager.removeConnectionTime(sessionId);
            sessionManager.removeClient(sessionId);
            System.out.println(
                    "DISCONNECTED : " + sessionId);
        });

    }
}