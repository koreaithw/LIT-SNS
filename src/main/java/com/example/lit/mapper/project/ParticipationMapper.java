package com.example.lit.mapper.project;

import com.example.lit.domain.vo.project.ParticipationVO;
import com.example.lit.domain.vo.review.LikeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ParticipationMapper {
    // 참여하기
    public void insert(ParticipationVO participationVO);
    // 성공하기, 실패하기 상태변경 review에서 프로젝트 별 review 수 카운트 result로 초기화
    public  void update(@Param("participationVO") ParticipationVO participationVO, @Param("result") Long result);
}
