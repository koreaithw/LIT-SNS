package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MessageVO {
    private Long sendUserNumber;
    private Long receiveUserNumber;
    private String messageRoom;
    private String messageContent;
    private String messageDate;
}
