package com.example.lit.controller;

import com.example.lit.domain.vo.user.UserFileVO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.service.User.UserService;
import com.example.lit.service.review.LitUpService;
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

    // 마이페이지 - 비밀번호 변경부분 유저 정보 띄우기
    @PostMapping("/oldPwCheck")
    public boolean dbOldPwCheck(@RequestBody UserVO userVO){
        log.info("이전 비밀번호 조회=============");
        log.info(userVO.getPassword() + "###################");
        log.info(userVO + "###################");
        log.info(userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber()) + " $$$$$$$$$$$");
        return userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber());
    }

    // 마이페이지 - 회원 탈퇴부분 유저 정보 띄우기
    @PostMapping("/withdrawCheck")
    public boolean withdrawCheck(@RequestBody UserVO userVO){
        log.info(userVO.getPassword() + "###################");
        log.info(userVO + "###################");
        log.info(userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber()) + " $$$$$$$$$$$");
        return userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber());
    }

    // 마이페이지 - 회원 탈퇴 버튼
    @DeleteMapping("/withdraw/{userNumber}")
    public String withdraw(@PathVariable("userNumber") Long userNumber){
        userService.remove(userNumber);
        return "회원 탈퇴 성공";
    }

    // 유저 프로필 사진 불러오기
    @GetMapping("/userImg")
    public UserFileVO getImg(Long userNumber) {
        return userService.getImg(userNumber);
    }

    // 마이페이지 - 비밀 번호 변경
    @PatchMapping("/modifyPw/{userNumber}/{newPassword}")
    public void modifyPw(@PathVariable("userNumber") Long userNumber, @PathVariable("newPassword") String newPassword){
        log.info("마이페이지 비밀 번호 변경..................");
        userService.modifyPw(userNumber, newPassword);
    }

    // 마이페이지 - 프로필 편집 닉네임 중복 검사
    @GetMapping("/profileEditNicknameCheck/{nickname}")
    public boolean profileEditNicknameCheck(@PathVariable("nickname") String nickname){
        log.info("프로필 편집 닉네임 중복 검사 =============");
        return userService.dbNicknameCheck(nickname);
    }

    @GetMapping("/getUser/{userNumber}")
    public UserVO getUser(@PathVariable("userNumber") Long userNumber){
        UserVO userVO = userService.read(userNumber);
        userVO.setUserFileList(userService.getImg(userVO.getUserNumber()));

        return userVO;
    }

    // 메달 4번 조건 달성 했을 때
    @GetMapping("/get4Medal/{userNumber}")
    public void get4Medal(@PathVariable("userNumber") Long userNumber){

        int medalCnt = userService.medalInsertBlock(userNumber,"4");

        if(medalCnt == 0) {
            userService.insertMedal(userNumber, "4");
        }

    }

    // 메달 5번 달성
    @GetMapping("/get5Medal/{userNumber}")
    public int get5Medal(@PathVariable("userNumber") Long userNumber){
        int reviewCnt = userService.medal5Condition(userNumber);
        int medalCnt = userService.medalInsertBlock(userNumber,"5");
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info(medalCnt + "#######################$$$$$$$$$$$$$$$$$$$#########");
        if(medalCnt == 0) {
            log.info(medalCnt + "################################");
            if (reviewCnt >= 100) {
                userService.insertMedal(userNumber, "5");
            }
        } else{
            reviewCnt = 100; // 달성률 게이지 넘어가는 것 방지
        }

        return reviewCnt;
    }

    // 메달 8번 달성
    @GetMapping("/get8Medal/{userNumber}/{categoryName}")
    public int get8Medal(@PathVariable("userNumber") Long userNumber, @PathVariable("categoryName") String category){
        int exerciseCategoryCnt = userService.medal8Condition(userNumber, category);
        int medalCnt = userService.medalInsertBlock(userNumber,"8");

        if(medalCnt == 0) {
            if (exerciseCategoryCnt >= 5) {
                log.info("55555");
                userService.insertMedal(userNumber, "8");
                log.info("왜 안돼");
                exerciseCategoryCnt = 5;
            }
        } else{
            exerciseCategoryCnt = 5; // 달성률 게이지 넘어가는 것 방지
        }


        return exerciseCategoryCnt;
    }
}
