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
    //메달 획득
    public void insertMedal(Long userNumber, String medal){
        achievementMapper.insertMedal(userNumber, medal);
    }
    //4번째 메달 조건 - 메달 10개 모으기
    public int medal4Condition(Long userNumber) { return achievementMapper.medal4Condition(userNumber); }
}
