package com.example.lit.mapper;


import com.example.lit.mapper.project.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
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

    }
}
