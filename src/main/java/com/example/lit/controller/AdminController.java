package com.example.lit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    //private final 의존성 주입으로 초기화할 객체
    @GetMapping("/userManagement")
    public void userManagement(){

    }

    @GetMapping("/approvedProjectManagement")
    public void approvedProjectManagement(){

    }

    @GetMapping("/reportManagement")
    public void reportManagement(){}

    @GetMapping("/waitingProjectManagement")
    public void waitingProjectManagement(){}

    @GetMapping("/reviewManagement")
    public void reviewManagement(){}
}
