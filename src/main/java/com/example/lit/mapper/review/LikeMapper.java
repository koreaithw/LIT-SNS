package com.example.lit.mapper.review;

import com.example.lit.domain.vo.review.LikeDTO;
import com.example.lit.domain.vo.review.LikeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    // 좋아요
    public void insert(LikeVO likeVO);
    // 좋아요(취소)
    public void delete(LikeVO likeVO);
    // 좋아요 갯수 카운트
    public Long getTotal(Long reviewNumber);
    // 좋아요 확인
    public int checkLike(Long userNumber, Long reviewNumber);
    // 좋아요 리스트(알림용)
    public List<LikeDTO> getList(Long userNumber);

}
