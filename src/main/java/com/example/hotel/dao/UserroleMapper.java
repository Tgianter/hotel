package com.example.hotel.dao;

import com.example.hotel.model.Userrole;
import com.example.hotel.model.UserroleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface UserroleMapper {
    long countByExample(UserroleExample example);

    int deleteByExample(UserroleExample example);

    int deleteByPrimaryKey(@Param("uid") Integer uid, @Param("rid") Integer rid);

    int insert(Userrole record);

    int insertSelective(Userrole record);

    List<Userrole> selectByExample(UserroleExample example);

    int updateByExampleSelective(@Param("record") Userrole record, @Param("example") UserroleExample example);

    int updateByExample(@Param("record") Userrole record, @Param("example") UserroleExample example);
}