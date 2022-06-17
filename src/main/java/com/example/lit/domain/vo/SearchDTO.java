package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SearchDTO {
    private String startDate;
    private String endDate;
    private String keyword;
    private String kakao;
    private String type;
    private String category;
    private String status;
}
