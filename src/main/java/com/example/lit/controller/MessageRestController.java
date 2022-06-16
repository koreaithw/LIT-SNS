package com.example.lit.controller;

import com.example.lit.domain.vo.user.MessageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/message/*")
public class MessageRestController {

    @PostMapping("/send")
    public List<MessageVO> send(){
        return null;
    }
}
