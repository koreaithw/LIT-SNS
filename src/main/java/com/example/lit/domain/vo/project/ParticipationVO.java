package com.example.lit.domain.vo.project;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ParticipationVO {
    private Long projectNumber;
    private Long userNumber;
    private Long status;
    private String registerDate;
}
