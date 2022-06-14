package com.example.lit.mapper;

import com.example.lit.domain.vo.ProjectFileVO;
import com.example.lit.domain.vo.ReviewFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectFileMapper {
    public void insert(ProjectFileVO projectFileVO);
    public void delete(Long projectNumber);
    public List<ProjectFileVO> findByProjectNumber(Long projectNumber);
    public List<ProjectFileVO> getOldFiles();
}
