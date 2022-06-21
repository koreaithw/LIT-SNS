package com.example.lit.mapper.review;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.review.ReviewDTO;
>>>>>>> cd2b8955962488f33178cfb86132b107f60dafb3
import com.example.lit.domain.vo.review.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    //    리뷰 목록 가져오기
    public List<ReviewVO> getList(@Param("criteria") Criteria criteria, @Param("category") String category );
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
    //    성공, 실패용 인증 수 카운트
    public int resultCount();
    //  인증글 검색(관리자)
    public List<ReviewDTO> searchReview(SearchDTO searchDTO);
    //  오늘 등록된 인증글 수
    public int getTotalToday();
    //  차트 정보
    public Long getReviewChart(String date);
}
