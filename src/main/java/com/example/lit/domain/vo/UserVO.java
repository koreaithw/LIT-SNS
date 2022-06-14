package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private Long userNumber;
    private String userEmail;
    private String userName;
    private String userNickname;
    private String userPassword;
    private String userContent;
    private Long userStatus;
    private String userKakao;
    private String userRegisterDate;
    private Long achievementNumber;

    private UserFileVO userFileList;
}
