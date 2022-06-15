package com.example.lit.mapper.user;

import com.example.lit.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //회원가입
    public void insert(UserVO userVO);
    //로그인
    public boolean login(String id, String pw);
    //회원탈퇴
    public void delete(UserVO userVO);
    //내 정보 가져오기
    public UserVO getUser(Long userNum);
    //내 정보 수정
    public void update(UserVO userVO);
    //비밀번호 변경
    public void updatePw(UserVO userVO);



}
