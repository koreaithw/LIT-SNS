package com.example.lit.domain.dao.review;

import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.review.ReportDTO;
import com.example.lit.domain.vo.review.ReportVO;
import com.example.lit.mapper.review.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportDAO {
    private final ReportMapper reportMapper;

    // 신고하기
    public void register(ReportVO reportVO){ reportMapper.insert(reportVO);}
    // 신고 취소(작성자)
    public void remove(Long reportNumber){ reportMapper.delete(reportNumber);}

    //리포트 검색(관리자)
    public List<ReportDTO> searchReport(SearchDTO searchDTO){ return reportMapper.searchReport(searchDTO); }
}
