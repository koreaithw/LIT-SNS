package com.example.lit.controller;

import com.example.lit.domain.vo.user.UserFileVO;
import com.example.lit.domain.vo.user.UserVO;
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

    // 회원가입 - 이메일 중복검사
    @GetMapping("/dbEmailCheck/{email}")
    public boolean dbEmailCheck(@PathVariable("email") String email){
        log.info("이메일 중복검사=============");
        return userService.dbEmailCheck(email);
    }

    // 회원가입 - 닉네임 중복검사
    @GetMapping("/dbNicknameCheck/{nickname}")
    public boolean dbNicknameCheck(@PathVariable("nickname") String nickname){
        log.info("닉네임 중복검사=============");
        return userService.dbNicknameCheck(nickname);
    }

    // 마이페이지 - 팔로워 삭제하기
    @DeleteMapping("/removeFollower/{followerNumber}/{followingNumber}")
    public String removeFollower(@PathVariable("followerNumber") Long followerNumber, @PathVariable("followingNumber") Long followingNumber){
        userService.removeFollower(followerNumber, followingNumber);
        return "팔로워 삭제 성공" + followerNumber;
    }

    // 마이페이지 - 비밀번호 변경 - 이전 비밀번호 조회
    @PostMapping("/oldPwCheck")
    public boolean dbOldPwCheck(@RequestBody UserVO userVO){
        log.info("이전 비밀번호 조회=============");
        log.info(userVO.getPassword() + "###################");
        log.info(userVO + "###################");
        log.info(userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber()) + " $$$$$$$$$$$");
        return userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber());
    }

    // 마이페이지 - 회원 탈퇴
    @PostMapping("/withdrawCheck")
    public boolean withdrawCheck(@RequestBody UserVO userVO){
        log.info(userVO.getPassword() + "###################");
        log.info(userVO + "###################");
        log.info(userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber()) + " $$$$$$$$$$$");
        return userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber());
    }

    // 유저 프로필 사진 불러오기
    @GetMapping("/userImg")
    public UserFileVO getImg(Long userNumber) {
        return userService.getImg(userNumber);
    }

}
