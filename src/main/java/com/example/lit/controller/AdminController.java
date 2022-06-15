package com.example.lit.controller;

import com.example.lit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        log.info("***************************");
        log.info("AdminController : login(get)");
        log.info("***************************");
        return "/admin/login";
    }

    @PostMapping("/login")
    public String adminLogin(String id, String password){
        log.info("***************************");
        log.info("AdminController : login(post)");
        log.info("***************************");
        //아이디 비밀번호 확인
        return "/admin/user-management";
    }


    @GetMapping("/user")
    public String user(){
        log.info("***************************");
        log.info("AdminController : user(get)");
        log.info("***************************");
        return "/admin/user-management";
    }

    @GetMapping("/approvedProject")
    public String approvedProject(){
        log.info("***************************");
        log.info("AdminController : approvedProject(get)");
        log.info("***************************");
        return "/admin/approved-project-management";
    }

    @GetMapping("/report")
    public String  report(){
        log.info("***************************");
        log.info("AdminController : report(get)");
        log.info("***************************");
        return "/admin/report-management";
    }

    @GetMapping("/waitingProject")
    public String waitingProject(){
        log.info("***************************");
        log.info("AdminController : waitingProject(get)");
        log.info("***************************");
        return "/admin/waiting-project-management";
    }

    @GetMapping("/review")
    public String reviewManagement(){
        log.info("***************************");
        log.info("AdminController : review(get)");
        log.info("***************************");
        return "/admin/review-management";
    }


}
