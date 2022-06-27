package com.example.lit.controller;

import com.example.lit.domain.vo.user.UserFileVO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.service.User.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
public class UserRestController {
    private final UserService userService;

    //=============== 프로필 수정 ====================
    //모달 프로필 사진 바꾸기 -> 반환타입 미정
    @PostMapping("/changeImg")
    public void changeImg(MultipartFile[] uploadFiles, HttpSession session) throws IOException {
        if(uploadFiles == null){
            return;
        }
        String uploadFolder = "C:/upload";
        ArrayList<UserFileVO> files = new ArrayList<>();

        //        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        // 쉼표로 String을 넣으면 상위경로/하위경로 로 설정된다(그냥 / 써도되는데 변수사용하면 불편해서 쉼표사용)

        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }  //폴더가 없으면 해당 경로로 디렉토리 생성

        for (MultipartFile file : uploadFiles) {
            UserFileVO fileVO = new UserFileVO();
            String uploadFileName = file.getOriginalFilename();
            //            UUID
//            네트워크 상에서 각각의 객체들을 식별하기 위하여 사용되었다.
//            중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
            UUID uuid = UUID.randomUUID();
            fileVO.setName(uploadFileName);
            fileVO.setUuid(uuid.toString());
            fileVO.setUploadPath(getFolder());

            uploadFileName = uuid.toString() + "_" + uploadFileName;

            log.info("-------------------------------");
            log.info("Upload File Name : " + uploadFileName);
            log.info("Upload File size : " + file.getSize());

            File saveFile = new File(uploadPath, uploadFileName);
            file.transferTo(saveFile);

            if (checkImageType(saveFile)) {
                FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100);
                thumbnail.close();
                fileVO.setImage("1");
            }
            files.add(fileVO);
            fileVO.setUserNumber((Long)session.getAttribute("userNumber"));
            userService.modifyImg(fileVO);
        }

    }

    @GetMapping("/display")
    public byte[] getFile(String fileName) throws IOException{
        File file = new File("C:/upload/", fileName);
        log.info(file.toString());
        return FileCopyUtils.copyToByteArray(file);
    }

    private boolean checkImageType(File file) throws IOException {
        String contentType = Files.probeContentType(file.toPath());
        return contentType.startsWith("image");
    }

    private String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        return sdf.format(date);
    }

    // 회원가입 - 이메일 중복검사
    @GetMapping("/dbEmailCheck/{email}")
    public boolean dbEmailCheck(@PathVariable("email") String email) {
        log.info("이메일 중복검사=============");
        return userService.dbEmailCheck(email);
    }

    // 회원가입 - 닉네임 중복검사
    @GetMapping("/dbNicknameCheck/{nickname}")
    public boolean dbNicknameCheck(@PathVariable("nickname") String nickname) {
        log.info("닉네임 중복검사=============");
        return userService.dbNicknameCheck(nickname);
    }

    // 마이페이지 - 팔로워 삭제하기
    @DeleteMapping("/removeFollower/{followerNumber}/{followingNumber}")
    public String removeFollower(@PathVariable("followerNumber") Long followerNumber, @PathVariable("followingNumber") Long followingNumber) {
        userService.removeFollower(followerNumber, followingNumber);
        return "팔로워 삭제 성공" + followerNumber;
    }

    // 마이페이지 - 비밀번호 변경부분 유저 정보 띄우기
    @PostMapping("/oldPwCheck")
    public boolean dbOldPwCheck(@RequestBody UserVO userVO) {
        log.info("이전 비밀번호 조회=============");
        log.info(userVO.getPassword() + "###################");
        log.info(userVO + "###################");
        log.info(userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber()) + " $$$$$$$$$$$");
        return userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber());
    }

    // 마이페이지 - 회원 탈퇴부분 유저 정보 띄우기
    @PostMapping("/withdrawCheck")
    public boolean withdrawCheck(@RequestBody UserVO userVO) {
        log.info(userVO.getPassword() + "###################");
        log.info(userVO + "###################");
        log.info(userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber()) + " $$$$$$$$$$$");
        return userService.dbOldPwCheck(userVO.getPassword(), userVO.getUserNumber());
    }

    // 마이페이지 - 회원 탈퇴 버튼
    @DeleteMapping("/withdraw/{userNumber}")
    public String withdraw(@PathVariable("userNumber") Long userNumber, HttpSession session) {
        userService.remove((Long)session.getAttribute("userNumber"));
        session.invalidate();
        return "회원 탈퇴 성공";
    }

    // 유저 프로필 사진 불러오기
    @GetMapping("/userImg")
    public UserFileVO getImg(Long userNumber) {
        return userService.getImg(userNumber);
    }

    // 마이페이지 - 비밀 번호 변경
    @PatchMapping("/modifyPw/{userNumber}/{newPassword}")
    public void modifyPw(@PathVariable("userNumber") Long userNumber, @PathVariable("newPassword") String newPassword) {
        log.info("마이페이지 비밀 번호 변경..................");
        log.info(userNumber + "");
        log.info(newPassword + "");
        userService.modifyPw(userNumber, newPassword);
    }

    // 마이페이지 - 프로필 편집 닉네임 중복 검사
    @GetMapping("/profileEditNicknameCheck/{nickname}")
    public boolean profileEditNicknameCheck(@PathVariable("nickname") String nickname) {
        log.info("프로필 편집 닉네임 중복 검사 =============");
        return userService.dbNicknameCheck(nickname);
    }

    @GetMapping("/getUser/{userNumber}")
    public UserVO getUser(@PathVariable("userNumber") Long userNumber) {
        UserVO userVO = userService.read(userNumber);
        userVO.setUserFileList(userService.getImg(userVO.getUserNumber()));

        return userVO;
    }

}
