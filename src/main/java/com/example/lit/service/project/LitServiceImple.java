package com.example.lit.service.project;

import com.example.lit.domain.dao.project.ParticipationDAO;
import com.example.lit.domain.dao.project.ProjectDAO;
import com.example.lit.domain.dao.project.ProjectFileDAO;
import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ParticipationVO;
import com.example.lit.domain.vo.project.ProjectFileVO;
import com.example.lit.domain.vo.project.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LitServiceImple implements LitService{
    private final ParticipationDAO participationDAO;
    private final ProjectDAO projectDAO;
    private final ProjectFileDAO projectFileDAO;

    @Override
    public List<ProjectVO> getList(Criteria criteria, String category) {
        return projectDAO.getList(criteria, category);
    }

    @Override
    //트랜잭션으로 묶어서 처리
    @Transactional(rollbackFor = Exception.class)
    public void register(ProjectVO projectVO, ProjectFileVO projectFileVO) {
        //프로젝트 생성
        projectDAO.register(projectVO);

        //프로젝트 이미지 처리(1장)
        if(projectVO.getProjectFile() != null){
            projectVO.getProjectFile().setProjectNumber(projectVO.getProjectNumber());
            projectFileDAO.register(projectFileVO);
        }
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
    public void modify(ParticipationVO participationVO, Long result) {

    }

    @Override
    public void removeImg(Long projectNumber) {

    }

    @Override
    public List<ProjectFileVO> getOldFiles() {
        return null;
    }

    @Override
    public ProjectFileVO getImg(Long projectNumber) {
        return null;
    }
}
