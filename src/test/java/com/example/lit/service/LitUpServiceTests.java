package com.example.lit.service;

import com.example.lit.domain.vo.SearchDTO;
import com.example.lit.domain.vo.review.ReviewDTO;
import com.example.lit.service.review.LitUpService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LitUpServiceTests {
    @Autowired
    private LitUpService litUpService;

    @Test
    public void searchReview(){
        SearchDTO searchDTO = new SearchDTO();

        searchDTO.setCategory("hobby");
        searchDTO.setKeyword("");
        searchDTO.setType("review_number");

        litUpService.searchReview(searchDTO).stream().map(ReviewDTO::toString).forEach(log::info);
    }
}
