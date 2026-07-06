package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.example.backend.dto.JoinRoomRequestDto;
import com.example.backend.service.RoomService;

@Controller
public class WebSocketController {
    
    @Autowired
    private RoomService roomService;
    
    @MessageMapping("/join")
    public void joinRoom(JoinRoomRequestDto requestDto) {

        roomService.joinRoom(requestDto);

    }
}
