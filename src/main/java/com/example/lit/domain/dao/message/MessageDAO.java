package com.example.lit.domain.dao.message;

import com.example.lit.domain.vo.messsage.MessageDTO;
import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.mapper.message.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MessageDAO {
    private final MessageMapper messageMapper;

    //메세지 룸 생성
    public void register(MessageVO messageVO){ messageMapper.insert(messageVO); }

    //메세지 리스트 띄우기
    public List<MessageVO> getList(String roomId){ return messageMapper.getList(roomId); }

    //메세지 할 팔로워 목록 불러오기
    public List<UserVO> getFollowerList(Long userNumber){ return messageMapper.getFollowerList(userNumber); }

    public List<Long> getReceiveUserNumber(Long sendUserNumber){ return messageMapper.getReceiveUserNumber(sendUserNumber); }

    public Map<String, Object> getRecentMessage(Long receiveUserNumber){ return messageMapper.getRecentMessage(receiveUserNumber); }

    public List<UserVO> searchFollower(String keyword, Long userNumber){ return messageMapper.searchFollower(keyword, userNumber); }

//    public List<MessageDTO> getMessageList(MessageDTO messageDTO, Long sendUserNumber, Long receiveUserNumber){
//        return messageMapper.getMessageList(messageDTO, sendUserNumber, receiveUserNumber);
//    }
    public List<MessageDTO> getMessageList(MessageDTO messageDTO){
        return messageMapper.getMessageList(messageDTO);
    }
}
