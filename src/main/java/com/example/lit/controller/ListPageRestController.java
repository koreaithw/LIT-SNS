package com.example.lit.controller;

import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.domain.vo.review.ReviewVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/list/*")
public class ListPageRestController {
    //lits탭 리스트 (현재 페이지가 카테고리인지 신규인지 인기인지 받아오기)
    @GetMapping("/lits/{}")
    public List<ProjectVO> lits(){
        return null;
    }

    //litup탭 리스트
    @GetMapping("/litup/{}")
    public List<ReviewVO> litup(){
        return null;
    }

}
