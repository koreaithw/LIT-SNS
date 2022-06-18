package com.example.lit.controller;

import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.review.ReplyVO;
import com.example.lit.domain.vo.review.ReportVO;
import com.example.lit.domain.vo.review.ReviewVO;
import com.example.lit.service.review.LitUpService;
import com.example.lit.service.review.LitUpServiceImple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/litUp/*")
public class LitUpRestController {
    private final LitUpService litUpService;

    //모달창 인증글 상세 보기
    @GetMapping("/read")
    public ReviewVO read(){
        log.info("***************************");
        log.info("LitUpRestController : read(get)");
        log.info("***************************");

        return null;
    }

    //모달창 인증글 상세 댓글 작성 -> 전달 방식 다시 생각하기
    @GetMapping("/reply")
    public List<ReplyVO> registerReply(){
        log.info("***************************");
        log.info("LitUpRestController : registerReply(get)");
        log.info("***************************");

        return null;
    }

    //모달창 인증글 상세 댓글 삭제
    @DeleteMapping("/reply")
    public List<ReplyVO> deleteReply(){
        log.info("***************************");
        log.info("LitUpRestController : deleteReply(delete)");
        log.info("***************************");

        return null;
    }

    //모달창 인증글 상세 신고
    @GetMapping("/report")
    public String registerReport(ReportVO reportVO){
        log.info("***************************");
        log.info("LitUpRestController : registerReport(get)");
        log.info("***************************");

        litUpService.registerReport(reportVO);
        return "신고 성공";
    }

    //모달창 인증글 상세 좋아요 -> 뭘 반환해야 하는가? 성공여부?
    @GetMapping("/like")
    public String registerLike(){
        log.info("***************************");
        log.info("LitUpRestController : registerLike(get)");
        log.info("***************************");

        return null;
    }

//    ================= 인증글 작성 ====================
    //모달창 인증글 업로드
    @PostMapping("/register")
    public void register(){
        log.info("***************************");
        log.info("LitUpRestController : register(post)");
        log.info("***************************");
    }

    //모달창 인증글 작성하기 중 프로젝트 불러오기
    @GetMapping("/getProjectList")
    public List<ProjectVO> getProjectList(){
        log.info("***************************");
        log.info("LitUpRestController : getProjectList(post)");
        log.info("***************************");

        return null;
    }
}
