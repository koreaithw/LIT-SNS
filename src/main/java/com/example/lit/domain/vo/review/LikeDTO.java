package com.example.lit.domain.vo.review;

import com.example.lit.domain.vo.user.UserFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class LikeDTO {
    private Long reviewNumber;
    private Long userNumber;
    private String registerData;
    private String nickName;
    private UserFileVO userFileVO;
    private List<ReviewFileVO> reviewFileVO;
}
