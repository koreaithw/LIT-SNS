package com.example.lit.domain.dao.review;

import com.example.lit.domain.vo.Criteria;
import com.example.lit.domain.vo.review.ReplyVO;
import com.example.lit.mapper.review.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    //댓글 추가
    public void register(ReplyVO replyVO){ replyMapper.insert(replyVO);}
    //댓글 삭제
    public boolean remove(Long replyNumber){ return replyMapper.delete(replyNumber) != 0;}
    //댓글 수정
    public boolean modify(ReplyVO replyVO){ return replyMapper.update(replyVO) != 0;}
    //댓글 목록
    public List<ReplyVO> getList(Criteria criteria, Long reviewNumber){ return replyMapper.getList(criteria, reviewNumber); }
    //댓글 개수
    public int getTotal(Long reviewNumber){ return replyMapper.getTotal(reviewNumber); }
}
