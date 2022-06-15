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
    public String user(){
        log.info("***************************");
        log.info("AdminController : user");
        log.info("***************************");
        return "/admin/user-management";
    }

    @GetMapping("/approvedProject")
    public String approvedProject(){
        log.info("***************************");
        log.info("AdminController : approvedProject");
        log.info("***************************");
        return "/admin/approved-project-management";
    }

    @GetMapping("/report")
    public String  report(){
        log.info("***************************");
        log.info("AdminController : report");
        log.info("***************************");
        return "/admin/report-management";
    }

    @GetMapping("/waitingProject")
    public String waitingProject(){
        log.info("***************************");
        log.info("AdminController : waitingProject");
        log.info("***************************");
        return "/admin/waiting-project-management";
    }

    @GetMapping("/review")
    public String reviewManagement(){
        log.info("***************************");
        log.info("AdminController : review");
        log.info("***************************");
        return "/admin/review-management";
    }


}
