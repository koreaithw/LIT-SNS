package com.example.lit.domain.dao.review;

import com.example.lit.domain.vo.review.LikeVO;
import com.example.lit.mapper.review.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    LikeMapper likeMapper;

    // 신고하기
    public void register(LikeVO likeVO){ likeMapper.insert(likeVO);}
    // 신고 취소(작성자)
    public void remove(LikeVO likeVO){ likeMapper.insert(likeVO);}
}
