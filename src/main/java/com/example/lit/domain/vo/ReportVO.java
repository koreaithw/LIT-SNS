package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReportVO {
    private Long reportNumber;
    private Long userNumber;
    private Long reviewNumber;
    private String reportReason;
}
