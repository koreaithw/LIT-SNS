package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserFileVO {
    private String userFileUuid;
    private String userFileUploadPath;
    private String userFileName;
    private String userFileImage;
    private Long userNumber;
}
