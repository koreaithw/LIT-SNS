package com.example.lit.mapper.review;

import com.example.lit.domain.vo.review.LikeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    // 신고하기
    public void insert(LikeVO likeVO);
    // 신고 취소(작성자)
    public void delete(LikeVO likeVO);
}
