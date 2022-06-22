package com.example.lit.controller;

import com.example.lit.domain.vo.review.LikeVO;
import com.example.lit.domain.vo.review.ReviewVO;
import com.example.lit.domain.vo.user.FollowVO;
import com.example.lit.service.review.LitUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    //의존성 주입 객체 선언하기
    private final LitUpService litUpService;

    @GetMapping("/main")
    public String main(){
        log.info("******************************");
        log.info("MainController : main");
        log.info("******************************");
        return "/main/main";
    }
}
