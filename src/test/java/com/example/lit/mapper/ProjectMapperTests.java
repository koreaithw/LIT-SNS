package com.example.lit.mapper;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.mapper.project.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import oracle.sql.DATE;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectMapperTests {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void getListTest(){
        projectMapper.getList(new Criteria(1, 5),"popular").stream().map(ProjectVO::toString).forEach(log::info);
    }

    @Test
    public void insertTest(){
        ProjectVO projectVO = new ProjectVO();
        projectVO.setTitle("Testtitle");
        projectVO.setContent("TestContent");
        projectVO.setCategory("Testcate");
        projectVO.setAuthentication("TESTAuthen");
        projectVO.setStartDate("2022-06-15");
        projectVO.setEndDate("2022-06-15");

        projectMapper.insert(projectVO);

    }

    @Test
    public void getTest(){
        Long pjtNum = 11L;
        projectMapper.get(pjtNum);
    }

    @Test
    public void deleteTest(){
        Long pjtNum = 11L;
        projectMapper.delete(pjtNum);
    }

    @Test
    public void getTotalTest(){
        projectMapper.getTotal();
    }


}
