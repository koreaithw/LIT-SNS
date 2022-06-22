package com.example.lit.mapper.project;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.ListDTO;
import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.project.ProjectDTO;
import com.example.lit.domain.vo.project.ProjectVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper {
    //    프로젝트 목록 가져오기
    public List<ProjectVO> getList(@Param("criteria") Criteria criteria, @Param("category") String category);
    //    프로젝트 등록
    public void insert(ProjectVO projectVO);
    //    프로젝트 상세보기
    public ProjectVO get(Long projectNumber);
    //    프로젝트 상세 가져오기(리뷰작성용)
    public ProjectDTO getForReview(@Param("projectNumber") Long projectNumber, @Param("userNumber") Long userNumber);
    //    프로젝트 삭제 ( 관리자)
    public int delete(Long projectNumber);
    //    프로젝트 전체 개수
    public int getTotal();
    //    프로젝트 검색 (관리자)
    public List<ProjectDTO> searchProject(SearchDTO searchDTO);
    //  프로젝트 승인(상태변경, 관리자)
    public void changeStatus(@Param("projectNumber") Long projectNumber, @Param("status") Long status);
    // 프로젝트 상태로 토탈 가져오기
    public int getTotalByStatus(Long status);
    // 프로젝트 목록(메인)
    public List<ProjectVO> getList2(ListDTO listDTO);
}
