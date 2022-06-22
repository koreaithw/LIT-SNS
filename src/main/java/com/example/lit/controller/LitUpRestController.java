package com.example.lit.controller;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ProjectDTO;
import com.example.lit.domain.vo.project.ProjectFileVO;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.review.*;
import com.example.lit.domain.vo.user.UserFileVO;
import com.example.lit.service.User.UserService;
import com.example.lit.service.review.LitUpService;
import com.example.lit.service.review.LitUpServiceImple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/litUp/*")
public class LitUpRestController {
    private final LitUpService litUpService;
    private final UserService userService;

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
    public void register(@RequestBody ReviewVO reviewVO){
        log.info("***************************");
        log.info("LitUpRestController : register(post)");
        log.info("************** *************");
        litUpService.register(reviewVO);
    }

    @PostMapping("/uploadFile")
    public List<ReviewFileVO> upload(MultipartFile[] uploadFiles) throws IOException {
        String uploadFolder = "C:/upload";
        ArrayList<ReviewFileVO> files = new ArrayList<>();

//        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for(MultipartFile file : uploadFiles){
            ReviewFileVO reviewFileVO = new ReviewFileVO();
            String uploadFileName = file.getOriginalFilename();

            UUID uuid = UUID.randomUUID();
            reviewFileVO.setName(uploadFileName);
            reviewFileVO.setUuid(uuid.toString());
            reviewFileVO.setUploadPath(getFolder());

            uploadFileName = uuid.toString() + "_" + uploadFileName;

            log.info("--------------------------------");
            log.info("Upload File Name : " + uploadFileName);

            File saveFile = new File(uploadPath, uploadFileName);
            file.transferTo(saveFile);

            if(checkImageType(saveFile)){
                FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100);
                thumbnail.close();
                reviewFileVO.setImage("1");
            }
            files.add(reviewFileVO);
        }
        return files;
    }

    @GetMapping("/display")
    public byte[] getFile(String fileName) throws IOException{
        File file = new File("C:/upload/", fileName);
        log.info(file.toString());
        return FileCopyUtils.copyToByteArray(file);
    }

    @PostMapping("/delete")
    public void delete(String fileName){
        File file = new File("C:/upload/", fileName);
        if(file.exists()){ file.delete(); }

        file = new File("C:/upload/", fileName.replace("s_", ""));
        if(file.exists()){ file.delete(); }
    }

    private boolean checkImageType(File file) throws IOException{
        String contentType = Files.probeContentType(file.toPath());
        return contentType.startsWith("image");
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }

    @GetMapping("/profilePic")
    public UserFileVO getProfile(Long userNumber){
        log.info(userNumber.toString());
        return userService.getImg(userNumber);
    }


    //모달창 인증글 작성하기 중 프로젝트 불러오기
    @GetMapping("/getProjectList")
    public List<ProjectVO> getProjectList(){
        log.info("***************************");
        log.info("LitUpRestController : getProjectList(get)");
        log.info("***************************");

        return null;
    }


    //========== 메인 리스트 ===========
    @GetMapping("/getList2")
    public List<ReviewDTO> getList2(){
        log.info("***************************");
        log.info("LitUpRestController : getList2(get)");
        log.info("***************************");

        return null;
    }

    //모달창 인증글 작성하기 중 프로젝트 정보 가져오기
    @GetMapping("/getProject/{projectNumber}/{userNumber}")
    public ProjectDTO getProject(@PathVariable("projectNumber") Long projectNumber, @PathVariable("userNumber") Long userNumber){
        log.info("***************************");
        log.info("LitUpRestController : getProject(get)");
        log.info("***************************");

        return litUpService.readForReview(projectNumber, userNumber);
    }

}
