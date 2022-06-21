package com.example.lit.controller;


import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/message/*")
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/message")
    public String message(Long userNumber, Model model){
        log.info("******************************");
        log.info("ProjectController : message");
        log.info("******************************");

        userNumber = 1L;

        //메세지 페이지 이동할 때 메시지 한 유저 닉네임과 최근 메시지를 담아준다.
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<Long> receiveNumbers = messageService.getReceiveUserNumber(userNumber);

        for (Long receiveUser : receiveNumbers) {
            log.info("******************************");
            log.info(receiveUser.toString());
            log.info("******************************");
            mapList.add(messageService.getRecentMessage(receiveUser));
        }

        model.addAttribute("nicknameAndMessage", mapList);

        return "/message/message";
    }

//    @GetMapping("/close")
//    public String close() {
        //닫기 버튼 누를 시 static List에 저장되었던 객체들을
        //db에 하나씩 insert해준 뒤,
        //List를 비워줌
//        for (MessageVO message : MessageRestController.messageList) {
//            messageService.register(message);
//        }
//        MessageRestController.messageList.clear();

        //입력시마다 넣는 것으로 바꿨으므로 메세지창 나가기로 바꿈
//        return "/message/message";
//    }



}
