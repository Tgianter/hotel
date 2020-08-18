package com.example.hotel.dao;

import com.example.hotel.model.Client;
import com.example.hotel.model.ClientExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ClientMapper {
    int insertClient(Client client);

    long countByExample(ClientExample example);

    int deleteByExample(ClientExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Client record);

    int insertSelective(Client record);

    List<Client> selectByExample(ClientExample example);

    Client selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Client record, @Param("example") ClientExample example);

    int updateByExample(@Param("record") Client record, @Param("example") ClientExample example);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}