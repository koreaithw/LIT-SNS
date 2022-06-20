package com.example.lit.mapper;

import com.example.lit.domain.vo.review.ReportVO;
import com.example.lit.mapper.review.ReportMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ReportMapperTests {
    @Autowired
    private ReportMapper reportMapper;

    @Test
    public void insertTest(){
        ReportVO reportVO = new ReportVO();
        reportVO.setReviewNumber(1L);
        reportVO.setUserNumber(1L);
        reportVO.setReason("TestReason");

        reportMapper.insert(reportVO);

    }


    @Test
    public void deleteTest(){
        reportMapper.delete(1L);
    }

}
