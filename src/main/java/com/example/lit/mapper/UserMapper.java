package com.example.lit.mapper;

import com.example.lit.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //회원가입
    public void insert(UserVO userVO);

    //로그인
    public boolean login(String id, String pw);

    //로그아웃

    //회원탈퇴
    public void withdraw(UserVO userVO);

    //내 정보 가져오기

    //내 정보 수정

    //비밀번호 변경

    //프로필 사진 수정


}
