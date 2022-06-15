package com.example.lit.domain.dao.project;

import com.example.lit.domain.vo.project.ProjectFileVO;
import com.example.lit.mapper.project.ProjectFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectFileDAO {
    ProjectFileMapper projectFileMapper;
    // 프로젝트 이미지 넣기
    public void register(ProjectFileVO projectFileVO){}
    // 프로젝트 이미지 삭제
    public void remove(Long projectNumber){}
    // DB에 없는 이미지 삭제
    public List<ProjectFileVO> getOldFiles(){ return projectFileMapper.getOldFiles(); }
}
