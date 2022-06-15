package com.example.lit.mapper.user;

import com.example.lit.domain.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {
    //메세지 룸 생성
    public void insert(MessageVO messageVO);
    //메세지 보내기
    public void send(MessageVO messageVO);
}
