package com.example.lit.service;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.project.ParticipationVO;
import com.example.lit.domain.vo.project.ProjectFileVO;
import com.example.lit.domain.vo.project.ProjectVO;

import java.util.List;

public interface LitService {
    //    프로젝트 목록 가져오기
    public List<ProjectVO> getList(Criteria criteria);
    //    프로젝트 등록 (이미지 포함)
    public void register(ProjectVO projectVO, ProjectFileVO projectFileVO);
    //    프로젝트 상세보기
    public ProjectVO read(Long projectNumber);
    //    프로젝트 삭제
    public boolean remove(Long projectNumber);
    //    프로젝트 전체 개수
    public int getTotal();


    // 참여하기
    public void join(ParticipationVO participationVO);
    // 성공하기, 실패하기 상태변경 review에서 프로젝트 별 review 수 카운트 result로 초기화
    public void modify(ParticipationVO participationVO, Long result);


    // 프로젝트 이미지 넣기(따로 필요하면 사용)
//    public void registerImg(ProjectFileVO projectFileVO);
    // 프로젝트 이미지 삭제
    public void removeImg(Long projectNumber);
    // DB에 없는 이미지 삭제
    public List<ProjectFileVO> getOldFiles();
    // 사진 리스트
    public ProjectFileVO getImg(Long projectNumber);
}
