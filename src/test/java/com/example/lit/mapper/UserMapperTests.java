package com.example.lit.mapper;


import com.example.lit.domain.vo.user.UserVO;
import com.example.lit.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("abc");
        userVO.setName("asds");
        userVO.setNickname("azxcsd");
        userVO.setPassword("1234");
        userMapper.insert(userVO);
    }

    @Test
    public void loginTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("abc");
        userVO.setName("asds");
        userVO.setNickname("azxcsd");
        userVO.setPassword("1234");
        userMapper.insert(userVO);
    }


}
