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

    @GetMapping("/login")
    public String login(){
        log.info("***************************");
        log.info("AdminController : login");
        log.info("***************************");
        return "/admin/login";
    }

    @GetMapping("/user")
    public String userManagement(){
        log.info("***************************");
        log.info("AdminController : userManagement");
        log.info("***************************");
        return "/admin/user-management";
    }

    @GetMapping("/approvedProject")
    public String approvedProjectManagement(){
        log.info("***************************");
        log.info("AdminController : approvedProjectManagement");
        log.info("***************************");
        return "/admin/approved-project-management";
    }

    @GetMapping("/report")
    public String  reportManagement(){
        log.info("***************************");
        log.info("AdminController : reportManagement");
        log.info("***************************");
        return "/admin/report-management";
    }

    @GetMapping("/waitingProject")
    public String waitingProjectManagement(){
        log.info("***************************");
        log.info("AdminController : waitingProjectManagement");
        log.info("***************************");
        return "/admin/waiting-project-management";
    }

    @GetMapping("/review")
    public String reviewManagement(){
        log.info("***************************");
        log.info("AdminController : reviewManagement");
        log.info("***************************");
        return "/admin/review-management";
    }


}
