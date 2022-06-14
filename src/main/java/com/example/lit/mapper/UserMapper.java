package com.example.lit.mapper;

import com.example.lit.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //회원가입
    public void insert(UserVO userVO);
}
