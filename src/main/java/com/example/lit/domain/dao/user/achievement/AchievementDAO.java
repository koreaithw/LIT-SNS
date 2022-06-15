package com.example.lit.domain.dao.user.achievement;

import com.example.lit.domain.vo.user.FollowVO;
import com.example.lit.domain.vo.user.achievement.AchievementVO;
import com.example.lit.mapper.user.achievement.AchievementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AchievementDAO {
    private final AchievementMapper achievementMapper;

    //메달 추가
    public void register(AchievementVO achievementVO){ achievementMapper.insert(achievementVO); }
    //메달 전체 해금 유무 (?)
    public List<AchievementVO> getList(Long userNumber){ return achievementMapper.getList(userNumber); }
    //메달 하나 보기
    public AchievementVO read(Long userNumber){ return achievementMapper.get(userNumber); }

}