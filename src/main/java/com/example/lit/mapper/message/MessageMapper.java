package com.example.lit.mapper.message;

import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.domain.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageMapper {
    //메세지 룸 생성
    public void insert(MessageVO messageVO);

    //메세지 리스트 띄우기
    public List<MessageVO> getList(String room);

    //메세지 할 팔로워 목록 불러오기
    public List<UserVO> getFollowerList(Long userNumber);

    public Map<String, String> getResentMessage(Long receiveUserNumber);
}
