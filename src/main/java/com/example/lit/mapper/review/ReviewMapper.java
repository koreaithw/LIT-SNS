package com.example.lit.mapper.review;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    //    리뷰 목록 가져오기
    public List<ReviewVO> getList(Criteria criteria);
    //    리뷰 등록
    public void insert(ReviewVO reviewVO);
    //    리뷰 상세보기
    public ReviewVO get(Long reviewNumber);
    //    리뷰 삭제
    public int delete(Long reviewNumber);
    //    리뷰 수정
    public int update(ReviewVO reviewVO);
    //    리뷰 전체 개수
    public int getTotal();
}
