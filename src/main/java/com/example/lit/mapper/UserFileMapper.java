package com.example.lit.mapper;

import com.example.lit.domain.vo.UserFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFileMapper {
    public void insert(UserFileVO userFileVO);
    public void delete(Long userNumber);
    public List<UserFileVO> findByUserNumber(Long userNumber);
    public List<UserFileVO> getOldFiles();
}
