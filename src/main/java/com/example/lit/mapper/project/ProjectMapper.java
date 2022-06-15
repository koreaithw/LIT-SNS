package com.example.lit.mapper.project;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    //    프로젝트 목록 가져오기
    public List<ProjectVO> getList(Criteria criteria);
    //    프로젝트 등록
    public void insert(ProjectVO projectVO);
    //    프로젝트 상세보기
    public ProjectVO get(Long projectNumber);
    //    프로젝트 삭제 ( 관리자)
    public int delete(Long projectNumber);
    //    프로젝트 전체 개수
    public int getTotal();
}
