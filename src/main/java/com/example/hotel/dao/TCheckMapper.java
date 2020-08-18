package com.example.hotel.dao;

import com.example.hotel.model.TCheck;
import com.example.hotel.model.TCheckExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface TCheckMapper {
    long countByExample(TCheckExample example);

    int deleteByExample(TCheckExample example);

    int deleteByPrimaryKey(@Param("cid") Integer cid, @Param("rid") Integer rid);

    int insert(TCheck record);

    int insertSelective(TCheck record);

    List<TCheck> selectByExample(TCheckExample example);

    TCheck selectByPrimaryKey(@Param("cid") Integer cid, @Param("rid") Integer rid);

    int updateByExampleSelective(@Param("record") TCheck record, @Param("example") TCheckExample example);

    int updateByExample(@Param("record") TCheck record, @Param("example") TCheckExample example);

    int updateByPrimaryKeySelective(TCheck record);

    int updateByPrimaryKey(TCheck record);
}