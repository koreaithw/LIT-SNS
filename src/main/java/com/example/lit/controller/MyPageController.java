package com.example.lit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MyPageController {
    //의존성 주입 객체 생성하기

    @GetMapping("/mypage")
    public String mypage(){
        log.info("******************************");
        log.info("MyPageController : mypage");
        log.info("******************************");
        return "/mypage/mypage";
    }
}
