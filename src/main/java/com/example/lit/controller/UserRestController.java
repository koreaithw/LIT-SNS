package com.example.lit.controller;

import com.example.lit.service.User.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
public class UserRestController {
    private final UserService userService;

    //=============== 프로필 수정 ====================
    //모달 프로필 사진 바꾸기 -> 반환타입 미정
    @PostMapping("/changeImg")
    public void changeImg(){
    }
    
    //닉네임 중복확인
    @PostMapping("/checkNickName")
    public String checkNickName(){
        return null;
    }

    //비밀번호 확인
    @PostMapping("/checkPw")
    public String checkPw(){
        return null;
    }


    //============= 팔로잉 ===============

    @GetMapping("/following")
    public String following(){
        return null;
    }

    @GetMapping("/follower")
    public String follower(){
        return null;
    }

    @GetMapping("/follow")
    public String follow(){
        return null;
    }

}
