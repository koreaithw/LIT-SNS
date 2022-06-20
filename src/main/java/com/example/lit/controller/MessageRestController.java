package com.example.lit.controller;

import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/message/*")
public class MessageRestController {
    private final MessageService messageService;

    public static List<MessageVO> messageList = new ArrayList<MessageVO>();

    @PostMapping("/send")
    public void send(@RequestBody MessageVO messageVO){
        log.info("--------------------------------------------");
        log.info("메세지 보내기");
        log.info("--------------------------------------------");

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        messageVO.setMessageDate(sdf.format(now));

        // 메세지 입력할 때마다
        // static으로 선언한 리스트에 add해줌
        messageList.add(messageVO);
    }

    @GetMapping("/getFollowerList/{userNumber}")
    public List<UserVO> getFollowerList(@PathVariable Long userNumber){
        return messageService.getFollowerList(userNumber);
    }




}
