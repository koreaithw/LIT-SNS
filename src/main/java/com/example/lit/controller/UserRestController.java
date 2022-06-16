package com.example.lit.controller;

import com.example.lit.service.User.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
public class UserRestController {
    private final UserService userService;

    //모달 프로필 사진 바꾸기 -> 반환타입 미정
    @PostMapping("/changeImg")
    public void changeImg(){
    }
    


}
