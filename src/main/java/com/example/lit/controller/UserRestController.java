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
    public String checkNickName(String nickname){
        return null;
    }
//
//    //이메일 중복확인
//    @ResponseBody
//    @RequestMapping(value = "/dbEmailCheck", method = RequestMethod.POST)
//    public boolean dbEmailCheck(String email){
//        log.info("checkEmail====================");
//        return userService.dbEmailCheck(email);
//    }
//
    @GetMapping("/dbEmailCheck/{email}")
    public boolean dbEmailCheck(@PathVariable("email") String email){
        log.info("이메일 중복검사=============");
        return userService.dbEmailCheck(email);
    }

    @GetMapping("/dbNicknameCheck/{nickname}")
    public boolean dbNicknameCheck(@PathVariable("nickname") String nickname){
        log.info("닉네임 중복검사=============");
        return userService.dbNicknameCheck(nickname);
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


    // 마이페이지 팔로워 삭제하기
    @DeleteMapping("/removeFollower/{followerNumber}/{followingNumber}")
    public String removeFollower(@PathVariable("followerNumber") Long followerNumber, @PathVariable("followingNumber") Long followingNumber){
        userService.removeFollower(followerNumber, followingNumber);
        return "팔로워 삭제 성공" + followerNumber;
    }

}
