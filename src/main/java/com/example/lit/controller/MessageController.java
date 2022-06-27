package com.example.lit.controller;


import com.example.lit.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String message(HttpSession session, Model model){
        log.info("******************************");
        log.info("ProjectController : message");
        log.info("******************************");

        Long userNumber = Long.parseLong(session.getAttribute("userNumber").toString());
//        userNumber = 1L;

        //메세지 페이지 이동할 때 메시지 한 유저 닉네임과 최근 메시지를 담아준다.
        List<Map<String, Object>> sendList = new ArrayList<>();
        List<Map<String, Object>> receiveList = new ArrayList<>();
        List<Long> receiveNumbers = messageService.getReceiveUserNumber(userNumber);
        List<Long> sendNumbers = messageService.getSendUserNumber(userNumber);

        for (Long receiveUser : receiveNumbers) {
            log.info("******************************");
            log.info(receiveUser.toString());
            log.info("******************************");
            sendList.add(messageService.getRecentMessage(receiveUser));
        }

        for (Long sendUser : sendNumbers){
            receiveList.add(messageService.getRecentReceiveMessage(sendUser));
        }

        model.addAttribute("recentSendMessage", sendList);
        model.addAttribute("recentReceiveMessage", receiveList);

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
