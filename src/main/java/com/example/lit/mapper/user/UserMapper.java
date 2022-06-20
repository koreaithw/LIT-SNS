package com.example.lit.mapper.user;

import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.user.UserDTO;
import com.example.lit.domain.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //회원 가입
    public void insert(UserVO userVO);
    //로그인
    public int adminLogin(String email, String password);
    //회원 탈퇴
    public void delete(Long userNumber);
    //내 정보 가져 오기
    public UserVO getUser(Long userNumber);
    //내 정보 수정
    public void update(UserVO userVO);
    //비밀 번호 변경
    public void updatePw(@Param("userVO") UserVO userVO, @Param("newPassword") String newPassword);
    // 대표 메달 설정
    public void updateMedal(UserVO userVO);

    // 관리자 검색
    public List<UserDTO> userSearch(SearchDTO searchDTO);
    // 유저 토탈
    public int getTotal();
    // 차트 정보
    public Long getUserChart(String date);

    //카카오 로그인/회원가입
    public void kakaoInsert(UserVO userVO);
    //이메일 중복체크
    public int emailCheck(String email);
    //닉네임 중복체크
    public int nicknameCheck(String nickname);


}
