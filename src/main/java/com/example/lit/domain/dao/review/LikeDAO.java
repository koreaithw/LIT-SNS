package com.example.lit.domain.dao.review;

import com.example.lit.domain.vo.review.LikeDTO;
import com.example.lit.domain.vo.review.LikeVO;
import com.example.lit.mapper.review.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    private final LikeMapper likeMapper;

    // 좋아요
    public void register(LikeVO likeVO){ likeMapper.insert(likeVO);}
    // 좋아요 취소
    public void remove(LikeVO likeVO){ likeMapper.delete(likeVO);}
    // 좋아요 갯수
    public Long getTotal(Long reviewNumber){ return likeMapper.getTotal(reviewNumber);}
    // 좋아요 확인
    public int checkLike(Long userNumber, Long reviewNumber){return likeMapper.checkLike(userNumber, reviewNumber);}

    // 좋아요 리스트(알림용)
    public List<LikeDTO> getList(Long userNumber) {return likeMapper.getList(userNumber);}
}
