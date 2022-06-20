package com.example.lit.domain.dao.message;

import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.mapper.message.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageDAO {
    private final MessageMapper messageMapper;

    //메세지 룸 생성
    public void register(MessageVO messageVO){ messageMapper.insert(messageVO); }

    //메세지 리스트 띄우기
    public List<MessageVO> getList(String room){ return messageMapper.getList(room); }

    //메세지 할 팔로워 목록 불러오기
    public List<UserVO> getFollowerList(Long userNumber){ return messageMapper.getFollowerList(userNumber); }
}
