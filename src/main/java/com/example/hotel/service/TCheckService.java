package com.example.hotel.service;

import com.example.hotel.model.TCheck;

import java.util.List;

public interface TCheckService {
    int addTCheck(TCheck tCheck);
    int deleteByCid(String cid);
    int updateTCheck(TCheck tCheck);
    TCheck getTCheckByCid(String cid);
    List<TCheck> getTChecksByRid(int rid);
    List<TCheck> getAllCheck();
}
