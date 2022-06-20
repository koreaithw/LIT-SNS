package com.example.lit.service.review;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.review.*;

import java.util.List;

public interface LitUpService {
    // 좋아요
    public void registerLike(LikeVO likeVO);
    // 좋아요 취소(작성자)
    public void removeLike(LikeVO likeVO);
    // 좋아요 갯수 카운트
    public Long getLikeTotal(Long reviewNumber);


    //댓글 추가
    public void registerReply(ReplyVO replyVO);
    //댓글 삭제
    public boolean removeReply(Long replyNumber);
    //댓글 수정
    public boolean modifyReply(ReplyVO replyVO);
    //댓글 목록
    public List<ReplyVO> getReplyList(Criteria criteria, Long reviewNumber);
    //댓글 개수
    public int getTotalReply(Long reviewNumber);


    // 신고하기
    public void registerReport(ReportVO reportVO);
    // 신고 취소(작성자)
    public void removeReport(Long reportNumber);


    //    리뷰 목록 가져오기
    public List<ReviewVO> getList(Criteria criteria, String category);
    //    리뷰 등록
    public void register(ReviewVO reviewVO);
    //    리뷰 상세보기
    public ReviewVO read(Long reviewNumber);
    //    리뷰 삭제
    public boolean remove(Long reviewNumber);
    //    리뷰 수정
    public boolean modify(ReviewVO reviewVO);
    //    리뷰 전체 개수
    public int getTotal();
    //    성공, 실패용 인증 수 카운트
    public int resultCount();


    // 사진 추가
    public void registerImg(ReviewFileVO reviewFileVO);
    // 사진 삭제
    public void removeImg(Long reviewNumber);
    // 사진 수정
    public void modifyImg(ReviewFileVO reviewFileVO);
    // 사진 리스트
    public List<ReviewFileVO> getImgs(Long reviewNumber);
    // DB에 없는 이미지 삭제
    public List<ReviewFileVO> getOldFiles();
}
