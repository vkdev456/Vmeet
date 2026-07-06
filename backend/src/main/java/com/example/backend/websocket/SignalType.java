package com.example.backend.websocket;

public enum SignalType {
    JOIN,
    LEAVE,

    OFFER,
    ANSWER,
    ICE_CANDIDATE,

    CHAT,

    MUTE,
    UNMUTE,

    VIDEO_ON,
    VIDEO_OFF,

    SCREEN_SHARE_START,
    sCREEN_sHARE_STOP
    
}
