package com.example.lit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/detail/*")
@Slf4j
public class DetailController {
    //의존성 주입 객체 생성하기

<<<<<<< HEAD
    @RequestMapping("projectDetail")
=======
    @RequestMapping("/projectDetail")
>>>>>>> a0f4201232026838b0c88660d52bea0f35d9f805
    public String projectDetail(){
        log.info("******************************");
        log.info("DetailController : projectDetail");
        log.info("******************************");
        return "/detail/projectDetail";
    }
}
