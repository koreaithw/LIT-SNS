package com.example.lit.controller;

import com.example.lit.service.User.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;

    //테스트
    @GetMapping("/changePw")
    public String changePw(){
        log.info("******************************");
        log.info("changeInfoController : changePw");
        log.info("******************************");
        return "/changeinfo/changePw";
    }
    //테스트
    @GetMapping("/editInfo")
    public String editInfo(){
        log.info("******************************");
        log.info("changeInfoController : editInfo");
        log.info("******************************");
        return "/changeinfo/editInfo";
    }
    //테스트
    @GetMapping("/withdraw")
    public String withdraw(){
        log.info("******************************");
        log.info("changeInfoController : withdraw");
        log.info("******************************");
        return "/changeinfo/withdraw";
    }
    //테스트
    @GetMapping("/login")
    public String login(){
        log.info("******************************");
        log.info("LoginController : login");
        log.info("******************************");
        return "/login/login";
    }
    //테스트
    @GetMapping("/join")
    public String join(){
        log.info("******************************");
        log.info("LoginController : join");
        log.info("******************************");
        return "/login/join";
    }

}
