package com.example.lit.service.message;

import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.domain.vo.user.UserVO;

import java.util.List;

public interface MessageService {
    //메세지 룸 생성
    public void register(MessageVO messageVO);

    //메세지 리스트 띄우기
    public List<MessageVO> getList(String room);

    //메세지 할 팔로워 목록 불러오기
    public List<UserVO> getFollowerList(Long userNumber);
}
