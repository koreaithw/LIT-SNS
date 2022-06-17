package com.example.lit.domain.dao.user;

import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    //회원 가입
    public void register(UserVO userVO){ userMapper.insert(userVO); }
    //로그인
    public boolean login(String email, String pw){ return userMapper.login(email, pw) != 0; }
    //회원 탈퇴
    public void remove(Long userNumber){ userMapper.delete(userNumber); }
    //내 정보 가져 오기
    public UserVO getUser(Long userNumber){ return userMapper.getUser(userNumber); }
    //내 정보 수정
    public void modify(UserVO userVO){ userMapper.update(userVO); }
    //비밀 번호 변경
    public void modifyPw(UserVO userVO, String newPassword){ userMapper.updatePw(userVO, newPassword); }
    // 대표 메달 설정
    public void modifyMedal(UserVO userVO){ userMapper.updateMedal(userVO); }
    // 관리자 유저 검색
    public List<UserVO> userSearch(SearchDTO searchDTO){ return userMapper.userSearch(searchDTO);}
}
