package com.example.lit.domain.dao.user;

import com.example.lit.domain.vo.user.MessageVO;
import com.example.lit.mapper.user.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageDAO {
    MessageMapper messageMapper;

    //메세지 룸 생성
    public void insert(MessageVO messageVO){ messageMapper.insert(messageVO); }
    //메세지 보내기
    public void send(MessageVO messageVO){ messageMapper.send(messageVO); }
    //메세지 리스트 띄우기
    public List<MessageVO> getList(MessageVO messageVO){ return messageMapper.getList(messageVO); }
}
