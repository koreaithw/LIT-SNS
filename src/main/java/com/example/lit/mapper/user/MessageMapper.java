package com.example.lit.mapper.user;

import com.example.lit.domain.vo.user.MessageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    //메세지 룸 생성
    public void insert(MessageVO messageVO);
    //메세지 보내기
    public void send(MessageVO messageVO);
    //메세지 리스트 띄우기
    public List<MessageVO> getList(MessageVO messageVO);
}
