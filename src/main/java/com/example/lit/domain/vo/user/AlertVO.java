package com.example.lit.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AlertVO {
    private Long alertUser;
    private Long userNumber;
    private String typeAlert;
    private String registerDate;
}
