package com.example.lit.domain.dao.project;

import com.example.lit.domain.vo.project.ParticipationVO;
import com.example.lit.mapper.project.ParticipationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParticipationDAO {
    ParticipationMapper participationMapper;
    // 참여하기
    public void insert(ParticipationVO participationVO){ participationMapper.insert(participationVO); }
}
