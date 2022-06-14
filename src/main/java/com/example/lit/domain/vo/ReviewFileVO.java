package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReviewFileVO {
    private String reviewFileUuid;
    private String reviewFileUploadPath;
    private String reviewFileName;
    private String reviewFileImage;
    private Long reviewNumber;
    
}
