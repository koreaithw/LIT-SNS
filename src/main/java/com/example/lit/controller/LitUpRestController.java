package com.example.lit.controller;

import com.example.lit.domain.dao.review.ReviewFileDAO;
import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.ListDTO;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.review.*;
import com.example.lit.service.review.LitUpService;
import com.example.lit.service.review.LitUpServiceImple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/litUp/*")
public class LitUpRestController {
    private final LitUpService litUpService;

    //모달창 인증글 상세 보기
    @GetMapping("/read/{reviewNumber}")
    public ReviewVO read(@PathVariable("reviewNumber") Long reviewNumber){
        log.info("***************************");
        log.info("LitUpRestController : read(get)");
        log.info("***************************");


        return litUpService.read(reviewNumber);
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
    @GetMapping("/delete/{replyNumber}/{userNumber}")
    public boolean deleteReply(@PathVariable("replyNumber") Long replyNumber, @PathVariable("userNumber") Long userNumber){
        log.info("***************************");
        log.info("LitUpRestController : deleteReply(delete)");
        log.info("***************************");
        ReplyVO replyVO = new ReplyVO();
        replyVO.setUserNumber(userNumber);
        replyVO.setReplyNumber(replyNumber);
        return litUpService.removeReply(replyVO);

        }

    // 댓글 페이징
    @GetMapping("/reply/{reviewNumber}/{page}")
    public ReplyPageDTO getList(@PathVariable("page") int pageNum, @PathVariable("reviewNumber") Long reviewNumber){
        return new ReplyPageDTO(litUpService.getReplyList(new Criteria(pageNum,10),reviewNumber), litUpService.getTotalReply(reviewNumber));
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

    @GetMapping("/like/{userNumber}")
    public boolean getCheckLike(@PathVariable("userNumber") Long userNumber){
        return litUpService.getCheckLike(userNumber) == 1;
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

    //========== 메인 리스트 ===========
    @PostMapping("/getList2")
    public List<ReviewDTO> getList2(@RequestBody ListDTO listDTO){
        log.info("***************************");
        log.info("LitUpRestController : getList2(post)");
        log.info("***************************");

        litUpService.getList2(listDTO).stream().map(ReviewDTO::toString).forEach(log::info);
        return litUpService.getList2(listDTO);
    }

    @GetMapping("/display")
    public byte[] getFile(String fileName) throws IOException {
        File file = new File("C:/upload/", fileName);
        return FileCopyUtils.copyToByteArray(file);
    }
}
