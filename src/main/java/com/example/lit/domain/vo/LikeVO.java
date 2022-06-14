package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LikeVO {
    private Long reviewNumber;
    private Long userNumber;
}
