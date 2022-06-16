package com.example.lit.controller;


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


    @GetMapping("/message")
    public String message(){
        log.info("******************************");
        log.info("ProjectController : message");
        log.info("******************************");
        return "/project/message";
    }


}
