package com.example.lit.controller;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.review.ReviewVO;
import com.example.lit.service.project.LitServiceImple;
import com.example.lit.service.review.LitUpServiceImple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/list/*")
public class ListPageRestController {

    private final LitServiceImple litServiceImple;
    private final LitUpServiceImple litUpServiceImple;


    //lits탭 리스트 (현재 페이지가 카테고리인지 신규인지 인기인지 받아오기)
    @GetMapping("/lits/{category}")
    public List<ProjectVO> lits(@PathVariable("category") String category){
        Criteria criteria = new Criteria(1, 100);
        litServiceImple.getList( criteria, category);
        return null;
    }

    //litup탭 리스트
    @GetMapping("/litup/{category}")
    public List<ReviewVO> litup(@PathVariable("category") String category){
        Criteria criteria = new Criteria(1, 100);
        litUpServiceImple.getList( criteria, category);
        return null;
    }

}
