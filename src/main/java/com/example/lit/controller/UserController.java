package com.example.lit.controller;

import com.example.lit.domain.vo.user.FollowVO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.domain.vo.user.achievement.AchievementVO;
import com.example.lit.service.User.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;

    //이동
    @GetMapping("/changePw")
    public String goChangePwPage(Long userNumber, Model model){
        log.info("******************************");
        log.info("changeInfoController : changePw");
        log.info("******************************");
        userNumber = 2L; // 임시

        UserVO userVO = userService.getChangePwInfo(userNumber);
        model.addAttribute("userNumber", userNumber);
        model.addAttribute("nickName", userVO.getNickname());
        log.info(userVO.getUserNumber() + "########################");
        log.info(userVO.getNickname() + "########################");
        return "/changeinfo/changePw";
    }
    //이동
    @GetMapping("/editInfo")
    public String goEditInfoPage(Long userNumber, Model model){
        log.info("******************************");
        log.info("changeInfoController : editInfo");
        log.info("******************************");
        userNumber = 2L;

        UserVO userVO = userService.read(userNumber);
        model.addAttribute("userVO", userVO);

        return "/changeinfo/editInfo";
    }
    //이동
    @GetMapping("/withdraw")
    public String goWithdrawPage(Long userNumber, Model model){
        log.info("******************************");
        log.info("changeInfoController : withdraw");
        log.info("******************************");
        userNumber = 2L; // 임시

        UserVO userVO = userService.getChangePwInfo(userNumber);
        model.addAttribute("userNumber", userNumber);
        model.addAttribute("nickName", userVO.getNickname());
        return "/changeinfo/withdraw";
    }
    //이동
    @GetMapping("/login")
    public String goLoginPage(){
        log.info("******************************");
        log.info("LoginController : login");
        log.info("******************************");
        return "/login/login";
    }
    //이동
    @GetMapping("/join")
    public String goJoinPage(){
        log.info("******************************");
        log.info("LoginController : join");
        log.info("******************************");
        return "/login/join";
    }

    //정보 수정
    @PatchMapping("/changeInfo")
    public String changeInfo(){
        return null;
    }


    //가입
    @PostMapping("/join")
    public RedirectView register(UserVO userVO, RedirectAttributes rttr){
        userService.register(userVO);

        return new RedirectView("/user/login");
    }

    //로그인
    @PostMapping("/loginOk")
    public RedirectView login(String email, String password, Model model, HttpServletRequest req, RedirectAttributes rttr){
        try{
            HttpSession session = req.getSession();
            UserVO userVO = userService.login(email,password);
            /* ##### 유저 프로필 사진으로 수정 필요 #####*/
            model.addAttribute("info", userVO.getNickname() + "님 환영합니다.");
            session.setAttribute("userNumber", userVO.getUserNumber());

        }catch (Exception e){
            rttr.addFlashAttribute("loginStatus", false);
            return new RedirectView("/user/login");
        }
        return new RedirectView("/main");
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        log.info("로그아웃 컨트롤러 들어옴");
        req.getSession().invalidate();
        req.getSession(true);
        return "/main/main";
    }

    //카톡 가입은 api활용하기(카카오 id값(숫자) 가져오기)

    //마이페이지 데이터 가져와서 들어가기
    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session){
        log.info("마이페이지 컨트롤러 =============================");

        Long userNumber = (Long)session.getAttribute("userNumber");
        if(userNumber == null){
            return goLoginPage();
        }
        System.out.println("==============================================");
        System.out.println(userNumber);
        System.out.println("==============================================");
        UserVO userVO = userService.read(userNumber);
        List<UserVO> followerVO = userService.ModalFollower(userNumber);
        List<UserVO> followingVO = userService.ModalFollowing(userNumber);

        model.addAttribute("followerCnt", userService.MyFollowerCnt(userNumber));
        model.addAttribute("followingCnt", userService.MyFollowingCnt(userNumber));
        model.addAttribute("reviewCnt", userService.MyReviewCnt(userNumber));
        model.addAttribute("nickname", userVO.getNickname());
        model.addAttribute("content", userVO.getContent());
        model.addAttribute("userNumber", userNumber);

        model.addAttribute("modalFollower",followerVO);
        log.info("###################  follower모달정보     " + followerVO);
        model.addAttribute("modalFollowing",followingVO);
        log.info("###################  following모달정보     " + followingVO);

        return "/mypage/mypage";
    }

    // 유저 페이지
    @GetMapping("/userPage/{userNumber}")
    public String userPage(Model model, HttpSession session, @PathVariable("userNumber") Long userNumber){

        Long sessionNumber = (Long)session.getAttribute("userNumber");
        if(sessionNumber == null){
            return goLoginPage();
        }
        System.out.println("==============================================");
        System.out.println(userNumber);
        System.out.println("==============================================");
        UserVO userVO = userService.read(userNumber);
        List<UserVO> followerVO = userService.ModalFollower(userNumber);
        List<UserVO> followingVO = userService.ModalFollowing(userNumber);

        model.addAttribute("followerCnt", userService.MyFollowerCnt(userNumber));
        model.addAttribute("followingCnt", userService.MyFollowingCnt(userNumber));
        model.addAttribute("reviewCnt", userService.MyReviewCnt(userNumber));
        model.addAttribute("nickname", userVO.getNickname());
        model.addAttribute("content", userVO.getContent());
        model.addAttribute("userNumber", userNumber);

        model.addAttribute("modalFollower",followerVO);
        log.info("###################  follower모달정보     " + followerVO);
        model.addAttribute("modalFollowing",followingVO);
        log.info("###################  following모달정보     " + followingVO);

        return "/mypage/mypage";
    }

    @PostMapping("/updateEditInfo")
    public String updateEditInfo(UserVO userVO, Model model){
        userVO.setUserNumber(2L);
        userService.modify(userVO);
        return goEditInfoPage(2L,model);
    }

//    *************************************
//    MEDAL 메달
//    *************************************
    @GetMapping("/getMedal/{userNumber}")
    @ResponseBody
    public List<String> getMedal(@PathVariable("userNumber") Long userNumber){
        log.info("getMedal................ : " + userNumber);
        return userService.getMedal(userNumber);
    }
}
