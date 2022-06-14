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
    public String userManagement(){
        log.info("***************************");
        log.info("/userManagement");
        log.info("***************************");
        return "/admin/user-management";
    }

    @GetMapping("/approvedProjectManagement")
    public String approvedProjectManagement(){
        log.info("***************************");
        log.info("/approvedProjectManagement");
        log.info("***************************");
        return "/admin/approved-project-management";
    }

    @GetMapping("/reportManagement")
    public String  reportManagement(){
        log.info("***************************");
        log.info("/reportManagement");
        log.info("***************************");
        return "/admin/report-management";
    }

    @GetMapping("/waitingProjectManagement")
    public String waitingProjectManagement(){
        log.info("***************************");
        log.info("/waitingProjectManagement");
        log.info("***************************");
        return "/admin/waiting-project-management";
    }

    @GetMapping("/reviewManagement")
    public String reviewManagement(){
        log.info("***************************");
        log.info("/reviewManagement");
        log.info("***************************");
        return "/admin/report-management";
    }
}
