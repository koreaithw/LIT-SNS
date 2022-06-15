package com.example.lit.mapper.user;

import com.example.lit.domain.vo.user.FollowVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowMapper {
    // 팔로우
    public void insert(FollowVO followVO);
    // 팔로우 취소
    public void delete(FollowVO followVO);
}
