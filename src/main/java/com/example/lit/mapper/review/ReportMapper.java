package com.example.lit.mapper.review;

import com.example.lit.domain.vo.review.ReportVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {
    // 신고하기
    public void insert(ReportVO reportVO);
    // 신고 취소(작성자)
    public void delete(Long reportNumber);
}
