package com.example.lit.service;

import com.example.lit.domain.dao.user.FollowDAO;
import com.example.lit.domain.dao.user.MessageDAO;
import com.example.lit.domain.dao.user.UserDAO;
import com.example.lit.domain.dao.user.UserFileDAO;
import com.example.lit.domain.dao.user.achievement.AchievementDAO;
import com.example.lit.domain.vo.user.FollowVO;
import com.example.lit.domain.vo.user.MessageVO;
import com.example.lit.domain.vo.user.UserFileVO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.domain.vo.user.achievement.AchievementVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService{
    private final AchievementDAO achievementDAO;
    private final FollowDAO followDAO;
    private final MessageDAO messageDAO;
    private final UserDAO userDAO;
    private final UserFileDAO userFileDAO;

    @Override
    public void register(UserVO userVO) {

    }

    @Override
    public boolean login(String email, String pw) {
        return false;
    }

    @Override
    public void remove(Long userNumber) {

    }

    @Override
    public UserVO read(Long userNumber) {
        return null;
    }

    @Override
    public void modify(UserVO userVO) {

    }

    @Override
    public void modifyPw(UserVO userVO, String newPassword) {

    }

    @Override
    public void modifyMedal(UserVO userVO) {

    }

    @Override
    public void registerImg(UserFileVO userFileVO) {

    }

    @Override
    public void removeImg(Long userNumber) {

    }

    @Override
    public void modifyImg(UserFileVO userFileVO) {

    }

    @Override
    public List<UserFileVO> getOldFiles() {
        return null;
    }

    @Override
    public void follow(FollowVO followVO) {

    }

    @Override
    public void removeFollow(FollowVO followVO) {

    }

    @Override
    public void registerMessageRoom(MessageVO messageVO) {

    }

    @Override
    public List<MessageVO> getMessageList(MessageVO messageVO) {
        return null;
    }

    @Override
    public void registerMedal(AchievementVO achievementVO) {

    }

    @Override
    public List<AchievementVO> getMedalList(Long userNumber) {
        return null;
    }

    @Override
    public AchievementVO readMedal(Long userNumber) {
        return null;
    }
}
