package com.example.lit.service.message;

import com.example.lit.domain.dao.message.MessageDAO;
import com.example.lit.domain.vo.messsage.MessageVO;
import com.example.lit.domain.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImple implements MessageService{
    private final MessageDAO messageDAO;

    @Override
    public void register(MessageVO messageVO) {
        messageDAO.register(messageVO);
    }

    @Override
    public List<MessageVO> getList(String room) {
        return messageDAO.getList(room);
    }

    @Override
    public List<UserVO> getFollowerList(Long userNumber) {
        return messageDAO.getFollowerList(userNumber);
    }
}
