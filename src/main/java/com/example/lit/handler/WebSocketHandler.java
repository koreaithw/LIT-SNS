package com.example.lit.handler;

import com.example.lit.domain.dao.message.ChatRoomRepository;
import com.example.lit.domain.dao.message.MessageDAO;
import com.example.lit.domain.vo.messsage.MessageRoom;
import com.example.lit.domain.vo.messsage.MessageVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {
    private final ChatRoomRepository chatRoomRepository;
    private final ObjectMapper objectMapper;

//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        log.info("메세지 전송 = {} : {}",session,message.getPayload());
//        String msg = message.getPayload();
//        MessageVO messageVO = objectMapper.readValue(msg,MessageVO.class);
//        MessageRoom messageRoom = chatRoomRepository.findRoomById(messageVO.getRoomId());
//        messageRoom.handleMessage(session,messageVO,objectMapper);
//    }

}
