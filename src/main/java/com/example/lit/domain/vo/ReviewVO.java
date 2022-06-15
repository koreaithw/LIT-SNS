package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ReviewVO {
    private Long reviewNumber;
    private Long userNumber;
    private Long projectNumber;
    private String content;
    private String registerDate;

    private List<ReviewFileVO> reviewFileList;
}
