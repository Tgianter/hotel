package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.TCheckMapper;
import com.example.hotel.model.TCheck;
import com.example.hotel.model.TCheckExample;
import com.example.hotel.service.ClientService;
import com.example.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TCheckService implements com.example.hotel.service.TCheckService {
    @Autowired
    TCheckMapper checkMapper;
    @Autowired
    ClientService clientService;
    @Autowired
    RoomService roomService;
    @Override
    public int addTCheck(TCheck tCheck) {
        return checkMapper.insert(tCheck);
    }

    @Override
    public int deleteByCid(String cid) {
        int id=clientService.selectById(cid).getTid();
        TCheckExample example= new TCheckExample();
        TCheckExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(id);
        return checkMapper.deleteByExample(example);
    }

    @Override
    public int updateTCheck(TCheck tCheck) {
        return checkMapper.updateByPrimaryKey(tCheck);
    }

    @Override
    public TCheck getTCheckByCid(String cid) {
        int id=clientService.selectById(cid).getTid();
        TCheckExample example =new TCheckExample();
        TCheckExample.Criteria criteria =example.createCriteria();
        criteria.andCidEqualTo(id);
        List<TCheck> checks=checkMapper.selectByExample(example);
        if(checks.size()<1){
            return null;
        }else{
            return checks.get(0);
        }
    }

    @Override
    public List<TCheck> getTChecksByRid(int rid) {
        int id=roomService.getRoomById(rid).getId();
        TCheckExample example=new TCheckExample();
        TCheckExample.Criteria criteria=example.createCriteria();
        criteria.andRidEqualTo(id);
        return checkMapper.selectByExample(example);
    }

    @Override
    public List<TCheck> getAllCheck() {
        TCheckExample example= new TCheckExample();
        example.setOrderByClause("rid asc");
        return checkMapper.selectByExample(example);
    }
}
