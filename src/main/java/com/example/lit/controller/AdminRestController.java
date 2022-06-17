package com.example.lit.controller;

import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.review.ReportVO;
import com.example.lit.domain.vo.review.ReviewVO;
import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.service.User.UserService;
import com.example.lit.service.project.LitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminRestController {
    private final UserService userService;
    private final LitService litService;

    //회원 검색
    @PostMapping("/searchUser")
    public List<UserVO> searchUser(@RequestBody SearchDTO searchDTO){
        log.info("***************************");
        log.info("AdminRestController : searchUser(post)");
        log.info("***************************");

        log.info(searchDTO.getKeyword());
        return userService.userSearch(searchDTO);
    }

    //회원 삭제
    @DeleteMapping("/user/{uno}")
    public void deleteUser(@PathVariable("uno") String list){
        log.info("***************************");
        log.info("AdminRestController : deleteUser(delete)");
        log.info("***************************");
        //삭제
        Arrays.stream(list.split("-")).map(Long::valueOf).forEach(i -> userService.remove(i));
    }

    //승인된 프로젝트 검색
    @PostMapping("/approvedProject/search")
    public List<ProjectVO> searchApprovedProject(){
        log.info("***************************");
        log.info("AdminRestController : searchApprovedProject(post)");
        log.info("***************************");

        return null;
    }

    //승인된 프로젝트 삭제
    @DeleteMapping("/approvedProject/{pno}")
    public List<ProjectVO> deleteApprovedProject(){
        log.info("***************************");
        log.info("AdminRestController : deleteApprovedProject(delete)");
        log.info("***************************");

        return null;
    }

    //신고 검색
    @PostMapping("/report/search")
    public List<ReportVO> searchReport(){
        log.info("***************************");
        log.info("AdminRestController : searchReport(post)");
        log.info("***************************");

        return null;
    }

    //신고된 글 삭제
    @DeleteMapping("/report/{rno}")
    public List<ReportVO> deleteReport(){
        log.info("***************************");
        log.info("AdminRestController : deleteReport(delete)");
        log.info("***************************");

        return null;
    }

    //신고 취소
    @DeleteMapping("/report/cancel/{rno}")
    public List<ReportVO> cancelReport(){
        log.info("***************************");
        log.info("AdminRestController : cancelReport(delete)");
        log.info("***************************");

        return null;
    }

    //신고된 글 보기
    @GetMapping("/report/view/{rno}")
    public Long viewReport(){
        log.info("***************************");
        log.info("AdminRestController : viewReport(get)");
        log.info("***************************");
        //검색 결과의 보기 버튼 누르면 해당 게시물이 새 창으로 떠야함(ajax 사용)

        return null;
    }

    //대기중인 프로젝트 검색
    @PostMapping("/waitingProject/search")
    public List<ProjectVO> searchWaitingProject(@RequestBody SearchDTO searchDTO){
        log.info("***************************");
        log.info("AdminRestController : searchWaitingProject(post)");
        log.info("***************************");

//        log.info(searchDTO.toString());
//        litService.searchProject(searchDTO).stream().forEach(ProjectVO::toString);



        return litService.searchProject(searchDTO);
    }

    //대기중인 프로젝트 삭제
    @DeleteMapping("/waitingProject/{pno}")
    public void deleteWaitingProject(@PathVariable("pno") String list){
        log.info("***************************");
        log.info("AdminRestController : deleteWaitingProject(delete)");
        log.info("***************************");

        //삭제
        Arrays.stream(list.split("-")).map(Long::valueOf).forEach(i -> litService.remove(i));
    }

    //대기중인 프로젝트 미리보기
    @GetMapping("/waitingProject/preview/{pno}")
    public ProjectVO viewWaitingProject(){
        log.info("***************************");
        log.info("AdminRestController : viewWaitingProject(get)");
        log.info("***************************");

        return null;
    }
    //대기중인 프로젝트 승인(상태 변경)
    @GetMapping("/waitingProject/{pno}/{status}")
    public void changeStatus(@PathVariable("pno")String pno, @PathVariable("status")Long status){
        log.info("***************************");
        log.info("AdminRestController : changeStatus(get)");
        log.info("***************************");

        Arrays.stream(pno.split("-")).forEach(p -> litService.changeStatus(Long.valueOf(p), status));
    }

    //인증글 검색
    @PostMapping("/review/search")
    public List<ReviewVO> searchReview(){
        log.info("***************************");
        log.info("AdminRestController : searchReview(post)");
        log.info("***************************");

        return null;
    }

    //인증글 삭제
    @DeleteMapping("/review/{rno}")
    public List<ReviewVO> deleteReview(){
        log.info("***************************");
        log.info("AdminRestController : deleteReview(delete)");
        log.info("***************************");

        return null;
    }

    //인증글 보기
    @GetMapping("/review/view/{rno}")
    public ReviewVO viewReview(){
        log.info("***************************");
        log.info("AdminRestController : viewReview(get)");
        log.info("***************************");

        return null;
    }
}































