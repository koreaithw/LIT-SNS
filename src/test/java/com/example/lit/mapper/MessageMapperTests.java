package com.example.lit.mapper;


import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.mapper.message.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Map;

@SpringBootTest
@Slf4j
public class MessageMapperTests {

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void getListTest(){
        log.info(messageMapper.getList("1번방").toString());

    }

    @Test
    public void insertTest(){
        log.info("메세지 입력");

        MessageVO messageVO = new MessageVO();
        messageVO.setSendUserNumber(1L);
        messageVO.setReceiveUserNumber(10L);
        messageVO.setRoom("1번방");
        messageVO.setContent("ddkdjfe");
        messageVO.setMessageDate("2022-06-19");
        messageMapper.insert(messageVO);

    }

    @Test
    public void getFollowerListTest(){
        messageMapper.getFollowerList(1L);
    }

    @Test
    public void getResentMessageTest() {
        Map<String, String> map =  messageMapper.getResentMessage(5L);
        log.info(map.values().toString());

    }

}
