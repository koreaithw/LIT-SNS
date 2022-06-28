package com.example.lit.controller;

import com.example.lit.service.KakaoService;
import com.example.lit.service.User.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.lit.domain.vo.user.UserVO;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class KakaoController {

    private final KakaoService kakaoService;
    private final UserService userService;

    @ResponseBody
    @GetMapping("/login")
    public void  kakaoCallback(@RequestParam String code, HttpSession session) throws Exception {
        log.info(code);
        // 카카오 토큰 생성
        String token = kakaoService.getKaKaoAccessToken(code);
        session.setAttribute("token", token);

        // 카카오에서 얻어와야할 정보들
        HashMap<String, Object> userInfo = kakaoService.getKakaoInfo(token);
        log.info("nickname" + userInfo.get("nickname"));
        log.info("email" + userInfo.get("email"));

        // 세션 심어줌
        session.setAttribute("nickname", userInfo.get("nickname"));
        session.setAttribute("email", userInfo.get("email"));

        // 얻어온 정보들로 회원가입 시킴
        UserVO userVO = new UserVO();
        userVO.setEmail((String) userInfo.get("nickname"));
        userVO.setNickname((String) userInfo.get("email"));
        userService.register(userVO);

    }

    @GetMapping("/logout")
    public void kakaoLogout(HttpSession session){
        log.info("logout");
        kakaoService.logoutKakao((String)session.getAttribute("token"));
        session.invalidate();
    }
}