package com.example.lit.controller;


import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/message/*")
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/message")
    public String message(){
        log.info("******************************");
        log.info("ProjectController : message");
        log.info("******************************");
        return "/message/message";
    }

    @GetMapping("/close")
    public String close() {
        //닫기 버튼 누를 시 static List에 저장되었던 객체들을
        //db에 하나씩 insert해준 뒤,
        //List를 비워줌
        for (MessageVO message : MessageRestController.messageList) {
            messageService.register(message);
        }
        MessageRestController.messageList.clear();
        return "/message/message";
    }



}
