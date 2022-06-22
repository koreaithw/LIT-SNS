package com.example.lit.controller;

import com.example.lit.domain.dao.project.ProjectFileDAO;
import com.example.lit.domain.dao.review.ReviewDAO;
import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.ListDTO;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.review.ReviewDTO;
import com.example.lit.domain.vo.review.ReviewVO;
import com.example.lit.service.project.LitServiceImple;
import com.example.lit.service.review.LitUpService;
import com.example.lit.service.review.LitUpServiceImple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/list/*")
public class ListPageRestController {
    //lits탭 리스트 (현재 페이지가 카테고리인지 신규인지 인기인지 받아오기)
    private final LitServiceImple litServiceImple;
    private final LitUpServiceImple litUpServiceImple;
    private final LitUpService litUpService;


    // 프로젝트 리스트
    @GetMapping("/lits/{cate}/{page}")
    public List<ProjectVO> lits(@PathVariable("page") int pageNum, @PathVariable("cate") String category){
        Criteria criteria = new Criteria(pageNum, 3);
        List<ProjectVO> projectVOS = litServiceImple.getList(criteria, category);

        for(ProjectVO projectVO : projectVOS){
            projectVO.setProjectFile(litServiceImple.getImg( projectVO.getProjectNumber() ));
        }
        return projectVOS;
    }

    //litup탭 리스트
    @GetMapping("/litups/{cate}/{page}")
    public List<ReviewDTO> litups(@RequestBody ListDTO listDTO){
        litUpService.getList2(listDTO).stream().map(ReviewDTO::toString).forEach(log::info);
        return litUpService.getList2(listDTO);
    }

}
