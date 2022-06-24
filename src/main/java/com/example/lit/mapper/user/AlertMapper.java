package com.example.lit.mapper.user;

import com.example.lit.domain.vo.user.AlertDTO;
import com.example.lit.domain.vo.user.AlertVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlertMapper {

    public void insert(AlertVO alertVO);

    public List<AlertDTO> alertList(Long userNumber);

}
