package com.example.lit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project/*")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {
    //의존성 주입 객체 선언하기

    @GetMapping("/message")
    public String message(){
        log.info("******************************");
        log.info("ProjectController : message");
        log.info("******************************");
        return "/project/message";
    }

    @GetMapping("/projectInfo")
    public String projectInfo(){
        log.info("******************************");
        log.info("ProjectController : projectInfo");
        log.info("******************************");
        return "/project/projectInfo";
    }

    @GetMapping("/projectWrite")
    public String projectWrite(){
        log.info("******************************");
        log.info("ProjectController : projectWrite");
        log.info("******************************");
        return "/project/projectWrite";
    }
}
