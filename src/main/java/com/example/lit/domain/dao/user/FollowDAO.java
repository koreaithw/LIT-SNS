package com.example.lit.domain.dao.user;

import com.example.lit.domain.vo.user.FollowVO;
import com.example.lit.mapper.user.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FollowDAO {
    FollowMapper followMapper;

    // 팔로우
    public void insert(FollowVO followVO){ followMapper.insert(followVO); }
    // 팔로우 취소
    public void delete(FollowVO followVO){ followMapper.delete(followVO); }
}
