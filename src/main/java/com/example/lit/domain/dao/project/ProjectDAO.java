package com.example.lit.domain.dao.project;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.mapper.project.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectDAO {
    ProjectMapper projectMapper;
    //    프로젝트 목록 가져오기
    public List<ProjectVO> getList(Criteria criteria){ return projectMapper.getList(criteria); }
    //    프로젝트 등록
    public void register(ProjectVO projectVO){ projectMapper.insert(projectVO);}
    //    프로젝트 상세보기
    public ProjectVO read(Long projectNumber){ return projectMapper.get(projectNumber); }
    //    리뷰 삭제
    public boolean remove(Long projectNumber){ return projectMapper.delete(projectNumber) != 0; }
    //    리뷰 수정
    public boolean modify(ProjectVO projectVO){ return projectMapper.update(projectVO) != 0; }
    //    리뷰 전체 개수
    public int getTotal(){ return projectMapper.getTotal(); }
}
