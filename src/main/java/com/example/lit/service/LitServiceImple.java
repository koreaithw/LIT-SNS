package com.example.lit.service;

import com.example.lit.domain.dao.project.ParticipationDAO;
import com.example.lit.domain.dao.project.ProjectDAO;
import com.example.lit.domain.dao.project.ProjectFileDAO;
import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ParticipationVO;
import com.example.lit.domain.vo.project.ProjectFileVO;
import com.example.lit.domain.vo.project.ProjectVO;
import com.example.lit.mapper.project.ProjectFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LitServiceImple implements LitService{
    private final ParticipationDAO participationDAO;
    private final ProjectDAO projectDAO;
    private final ProjectFileDAO projectFileDAO;

    @Override
    public List<ProjectVO> getList(Criteria criteria) {
        return null;
    }

    @Override
    public void register(ProjectVO projectVO, ProjectFileVO projectFileVO) {

    }

    @Override
    public ProjectVO read(Long projectNumber) {
        return null;
    }

    @Override
    public boolean remove(Long projectNumber) {
        return false;
    }

    @Override
    public int getTotal() {
        return 0;
    }

    @Override
    public void join(ParticipationVO participationVO) {

    }

    @Override
    public void removeImg(Long projectNumber) {

    }

    @Override
    public List<ProjectFileVO> getOldFiles() {
        return null;
    }
}
