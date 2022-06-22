package com.example.lit.controller;

import com.example.lit.domain.vo.review.LikeDTO;
import com.example.lit.service.User.UserService;
import com.example.lit.service.review.LitUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/alter")
public class AlterController {
    @Autowired
    private LitUpService litUpService;

    @Autowired
    private UserService userService;

    // 좋아요 목록 가져오기
    @GetMapping("/like/{userNumber}")
    public List<LikeDTO> getLikeList(@PathVariable("userNumber") Long userNumber){
        log.info("--------------------------------------------------------");
        List<LikeDTO> likeDTOS = litUpService.getLikeList(userNumber);
        for(LikeDTO likeDTO : likeDTOS) {
            likeDTO.setReviewFileVO(litUpService.getImgs(likeDTO.getReviewNumber()));
            likeDTO.setUserFileVO(userService.getImg(likeDTO.getUserNumber()));

        }
        log.info(likeDTOS.toString());
        return likeDTOS;
    }
}
