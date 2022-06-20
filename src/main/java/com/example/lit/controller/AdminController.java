package com.example.lit.controller;

import com.example.lit.service.User.UserService;
import com.example.lit.service.project.LitService;
import com.example.lit.service.review.LitUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final LitService litService;
    private final LitUpService litUpService;

    @GetMapping("/login")
    public String login(){
        log.info("***************************");
        log.info("AdminController : login(get)");
        log.info("***************************");
        return "/admin/login";
    }

    @PostMapping("/login")
    public RedirectView adminLogin(String email, String password){
        log.info("***************************");
        log.info("AdminController : login(post)");
        log.info("***************************");
        //아이디 비밀번호 확인
        String result =  userService.login(email, password) ? "/admin/user" : "/admin/login";
        //관리자 페이지는 단순히 email pw만 일치해서 들어갈 수 잇으면 안됨 => 수정해야함
        return new RedirectView(result);
    }


    @GetMapping("/user")
    public String user(Model model){
        log.info("***************************");
        log.info("AdminController : user(get)");
        log.info("***************************");
        model.addAttribute("total", userService.getTotal());

        return "/admin/user-management";
    }

    @GetMapping("/approvedProject")
    public String approvedProject(Model model){
        log.info("***************************");
        log.info("AdminController : approvedProject(get)");
        log.info("***************************");
        model.addAttribute("total", litService.getTotalByStatus(1L));
        return "/admin/approved-project-management";
    }

    @GetMapping("/report")
    public String  report(Model model){
        log.info("***************************");
        log.info("AdminController : report(get)");
        log.info("***************************");
        model.addAttribute("total", litUpService.getTotalTodayReport());

        return "/admin/report-management";
    }

    @GetMapping("/waitingProject")
    public String waitingProject(Model model){
        log.info("***************************");
        log.info("AdminController : waitingProject(get)");
        log.info("***************************");
        model.addAttribute("total", litService.getTotalByStatus(0L));
        return "/admin/waiting-project-management";
    }

    @GetMapping("/review")
    public String reviewManagement(Model model){
        log.info("***************************");
        log.info("AdminController : review(get)");
        log.info("***************************");

        model.addAttribute("total", litUpService.getTotalTodayReview());
        return "/admin/review-management";
    }


}
