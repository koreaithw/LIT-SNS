package com.example.lit.domain.dao.review;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.review.ReviewVO;
import com.example.lit.mapper.review.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewDAO {
    ReviewMapper reviewMapper;

    //    리뷰 목록 가져오기
    public List<ReviewVO> getList(Criteria criteria){ return reviewMapper.getList(criteria); }
    //    리뷰 등록
    public void register(ReviewVO reviewVO){ reviewMapper.insert(reviewVO); }
    //    리뷰 상세보기
    public ReviewVO read(Long reviewNumber){ return reviewMapper.get(reviewNumber); }
    //    리뷰 삭제
    public boolean remove(Long reviewNumber){ return reviewMapper.delete(reviewNumber) != 0; }
    //    리뷰 수정
    public boolean modify(ReviewVO reviewVO){ return reviewMapper.update(reviewVO) != 0; }
    //    리뷰 전체 개수
    public int getTotal(){ return reviewMapper.getTotal(); }
}
