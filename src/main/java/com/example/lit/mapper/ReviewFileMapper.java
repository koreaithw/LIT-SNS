package com.example.lit.mapper;

import com.example.lit.domain.vo.ReviewFileVO;
import com.example.lit.domain.vo.UserFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewFileMapper {
    public void insert(ReviewFileVO userFileVO);
    public void delete(Long reviewNumber);
    public List<ReviewFileVO> findByReviewNumber(Long reviewNumber);
    public List<ReviewFileVO> getOldFiles();
}
