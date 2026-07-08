package com.example.backend.config;

import com.corundumstudio.socketio.SocketIOServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocketServerRunner {

    private final SocketIOServer server;

    @PostConstruct
    public void start() {

        server.start();

        System.out.println("Socket.IO Server Started");
    }

    @PreDestroy
    public void stop() {

        server.stop();

    }
}