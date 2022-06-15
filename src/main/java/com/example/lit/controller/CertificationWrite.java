package com.example.lit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/certification/*")
@RequiredArgsConstructor
@Controller
public class CertificationWrite {
    //의존성 주입 객체 생성

    @RequestMapping("/write")
    public String write(){
        log.info("******************************");
        log.info("CertificationWrite : write");
        log.info("******************************");
        return "/certification/certificationWrite";
    }
}
