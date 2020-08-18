package com.example.hotel.dao;

import com.example.hotel.model.Rolepermission;
import com.example.hotel.model.RolepermissionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface RolepermissionMapper {
    long countByExample(RolepermissionExample example);

    int deleteByExample(RolepermissionExample example);

    int deleteByPrimaryKey(@Param("rid") Integer rid, @Param("pid") Integer pid);

    int insert(Rolepermission record);

    int insertSelective(Rolepermission record);

    List<Rolepermission> selectByExample(RolepermissionExample example);

    int updateByExampleSelective(@Param("record") Rolepermission record, @Param("example") RolepermissionExample example);

    int updateByExample(@Param("record") Rolepermission record, @Param("example") RolepermissionExample example);
}