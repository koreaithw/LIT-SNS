package com.example.lit.controller;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.review.*;
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
    @PostMapping("/reply")
    public String registerReply(@RequestBody ReplyVO replyVO){
        log.info("***************************");
        log.info("LitUpRestController : registerReply(get)");
        log.info("***************************");
        litUpService.registerReply(replyVO);
        return "댓글 생성 완료";
    }

    //모달창 인증글 상세 댓글 삭제
    @GetMapping("/reply/{replyNumber}")
    public String deleteReply(@PathVariable("replyNumber") Long replyNumber){
        log.info("***************************");
        log.info("LitUpRestController : deleteReply(delete)");
        log.info("***************************");
        if(litUpService.removeReply(replyNumber)){
            return "삭제 성공";}
        else{return "삭제 실패";}
        }

    @GetMapping("/reply/{reviewNumber}/{page}")
    public ReplyPageDTO getList(@PathVariable("page") int pageNum, @PathVariable("reviewNumber") Long reviewNumber){
        return new ReplyPageDTO(litUpService.getReplyList(new Criteria(pageNum,4),reviewNumber), litUpService.getTotalReply(reviewNumber));
    }


    //모달창 인증글 상세 신고
    @PostMapping("/report")
    public String registerReport(@RequestBody ReportVO reportVO){
        log.info("***************************");
        log.info("LitUpRestController : registerReport(get)");
        log.info("***************************");

        litUpService.registerReport(reportVO);
        return "신고 성공";
    }

    //모달창 인증글 상세 좋아요 -> 좋아요 전체 갯수도 같이 사용되어야 함
    @PostMapping("/like")
    public int registerLike(@RequestBody LikeVO likeVO){
        log.info("***************************");
        log.info("LitUpRestController : registerLike(get)");
        log.info("***************************");
        litUpService.registerLike(likeVO);
        return litUpService.getLikeTotal(likeVO.getReviewNumber()).intValue();
    }

    @PostMapping("/removeLike")
    public int removeLike(@RequestBody LikeVO likeVO){
        log.info("***************************");
        log.info("LitUpRestController : registerLike(get)");
        log.info("***************************");
        litUpService.removeLike(likeVO);
        return litUpService.getLikeTotal(likeVO.getReviewNumber()).intValue();
    }

    @GetMapping("/getLikeTotal/{reviewNumber}")
    public int getLikeTotal(@PathVariable("reviewNumber") Long reviewNumber){
        log.info("***************************");
        log.info("LitUpRestController : registerLike(get)");
        log.info("***************************");
        return litUpService.getLikeTotal(reviewNumber).intValue();
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
