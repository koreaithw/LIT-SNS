package com.example.lit.domain.vo.review;

import com.example.lit.domain.vo.user.UserFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LikeDTO {
    private Long reviewNumber;
    private Long userNumber;
    private String registerDate;
    private String nickName;
    private UserFileVO userFileVO;
    private ReviewFileVO reviewFileVO;
}
