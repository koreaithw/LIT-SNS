package com.example.lit.mapper;


<<<<<<< HEAD
=======
import com.example.lit.domain.vo.Criteria;
>>>>>>> 09c771e4c904f69bac0e76db1fc7998cf7fbb4cc
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
<<<<<<< HEAD
=======
    public void getListTest(){
        projectMapper.getList(new Criteria(1, 5),"popular").stream().map(ProjectVO::toString).forEach(log::info);
    }


    @Test
>>>>>>> 09c771e4c904f69bac0e76db1fc7998cf7fbb4cc
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
