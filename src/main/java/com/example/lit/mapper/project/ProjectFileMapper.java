package com.example.lit.mapper.project;

import com.example.lit.domain.vo.project.ProjectFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectFileMapper {
    // 프로젝트 이미지 넣기
    public void insert(ProjectFileVO projectFileVO);
    // 프로젝트 이미지 삭제
    public void delete(Long projectNumber);
    // DB에 없는 이미지 삭제
    public List<ProjectFileVO> getOldFiles();
}
