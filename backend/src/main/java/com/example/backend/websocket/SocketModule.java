package com.example.backend.websocket;

import com.corundumstudio.socketio.SocketIOServer;
import com.example.backend.dto.JoinCallDataDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class SocketModule {

    private final SocketSessionManager sessionManager;
    
    private final SocketIOServer server;

    @PostConstruct
    public void init() {

        server.addConnectListener(client -> {

            System.out.println("CONNECTED : " + client.getSessionId());

        });

        server.addEventListener(
        "join-call",
        JoinCallDataDto.class,
        (client, data, ackSender) -> {

            sessionManager.joinRoom(
                    data.getPath(),
                    client);

            System.out.println(
                    client.getSessionId()
                            + " joined "
                            + data.getPath());

        });

    }

}