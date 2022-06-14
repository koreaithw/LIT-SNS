package com.example.lit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/changeinfo/*")
@Slf4j
@RequiredArgsConstructor
public class ChangeInfoController {
    //의존성 주입할 객체 선언하기

    @GetMapping("/changePw")
    public String changePw(){
        log.info("******************************");
        log.info("changeInfoController : changePw");
        log.info("******************************");
        return "/changeinfo/changePw";
    }

    @GetMapping("/editInfo")
    public String editInfo(){
        log.info("******************************");
        log.info("changeInfoController : editInfo");
        log.info("******************************");
        return "/changeinfo/editInfo";
    }

    @GetMapping("/withdraw")
    public String withdraw(){
        log.info("******************************");
        log.info("changeInfoController : withdraw");
        log.info("******************************");
        return "/changeinfo/withdraw";
    }

}
