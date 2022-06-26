package com.example.lit.service.project;

import com.example.lit.domain.dao.project.ParticipationDAO;
import com.example.lit.domain.dao.project.ProjectDAO;
import com.example.lit.domain.dao.project.ProjectFileDAO;
import com.example.lit.domain.vo.ListDTO;
import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.project.ParticipationVO;
import com.example.lit.domain.vo.project.ProjectDTO;
import com.example.lit.domain.vo.project.ProjectFileVO;
import com.example.lit.domain.vo.project.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LitServiceImple implements LitService{
    private final ProjectDAO projectDAO;
    private final ProjectFileDAO projectFileDAO;
    private final ParticipationDAO participationDAO;


    @Override
    public List<ProjectVO> getList(ListDTO listDTO) {
        return projectDAO.getList(listDTO);
    }

    @Override
    //트랜잭션으로 묶어서 처리
    @Transactional(rollbackFor = Exception.class)
    public void register(ProjectVO projectVO) {

        //프로젝트 생성
        projectDAO.register(projectVO);

        //프로젝트 이미지 처리(1장)
        if(projectVO.getProjectFile() != null){
            ProjectFileVO projectFileVO = projectVO.getProjectFile();
            projectFileVO.setProjectNumber(projectVO.getProjectNumber());

            projectFileDAO.register(projectFileVO);
        }
    }

    @Override
    public ProjectDTO read(ProjectDTO projectDTO) {
        Long projectNumber = projectDTO.getUserNumber();
        Long userNumber = projectDTO.getUserNumber();

        ParticipationVO participationVO = new ParticipationVO();
            participationVO.setProjectNumber(projectNumber);
            participationVO.setUserNumber(userNumber);

       projectDTO = projectDAO.read(projectNumber);                                     // 기본 데이터 겟
            projectDTO.setReviewCount( projectDAO.reviewTotal(projectNumber) );         // 게시물 토탈
            projectDTO.setParticipationCount( projectDAO.challengeTotal(projectNumber));// 참가자 토탈
            projectDTO.setParticipationStatus( participationDAO.select( participationVO ) );
            projectDTO.setUserNumber( userNumber );
        return projectDTO;
    }

    @Override
    public boolean remove(Long projectNumber) {
        return projectDAO.remove(projectNumber);
    }

    @Override
    public int getTotal() {
        return 0;
    }

    @Override
    public void join(ParticipationVO participationVO) {
        participationDAO.register(participationVO);
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
        return projectFileDAO.getImg(projectNumber);
    }

    @Override
    public List<ProjectDTO> searchProject(SearchDTO searchDTO) {
        return projectDAO.searchProject(searchDTO);
    }

    @Override
    public void changeStatus(Long projectNumber, Long status) {
        projectDAO.changeStatus(projectNumber, status);
    }

    @Override
    public int getTotalByStatus(Long status) {
        return projectDAO.getTotalByStatus(status);
    }

    @Override
    public List<ProjectDTO> getMainList(ListDTO listDTO) {
        List<ProjectDTO> result = projectDAO.getMainList(listDTO).stream().map( project -> {
            ProjectFileVO projectFileVO = projectFileDAO.getImg(project.getProjectNumber());
            project.setProjectFile(projectFileVO);
            return project;
        }).collect(Collectors.toList());

        return result;
    }

}
