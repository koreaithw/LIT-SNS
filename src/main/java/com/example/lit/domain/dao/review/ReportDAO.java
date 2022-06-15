package com.example.lit.domain.dao.review;

import com.example.lit.domain.vo.review.ReportVO;
import com.example.lit.mapper.review.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReportDAO {
    ReportMapper reportMapper;

    // 신고하기
    public void register(ReportVO reportVO){ reportMapper.insert(reportVO);}
    // 신고 취소(작성자)
    public void remove(Long reportNumber){ reportMapper.delete(reportNumber);}
}
