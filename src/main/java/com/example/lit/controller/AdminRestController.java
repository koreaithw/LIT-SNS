package com.example.lit.controller;

import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminRestController {
    private final UserService userService;

    @PostMapping("/user/search")
    public List<UserVO> userSearch(){
        log.info("***************************");
        log.info("AdminRestController : userSearch(post)");
        log.info("***************************");
        return null;
    }

    @DeleteMapping("/user")
    public List<UserVO> userDelete(){
        log.info("***************************");
        log.info("AdminRestController : userDelete(delete)");
        log.info("***************************");
        //삭제 후 리스트 반환
        return null;
    }

    



}































