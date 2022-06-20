package com.example.lit.domain.vo.messsage;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.net.http.WebSocket;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
@Data
public class MessageRoom {
    private String roomId;
    private String roomName;
    private Set<WebSocket> sessions = new HashSet<>();

    public static MessageRoom create(String room){
        MessageRoom messageRoom = new MessageRoom();
        messageRoom.roomId = UUID.randomUUID().toString();
        messageRoom.roomName = room;
        return messageRoom;
    }




}
