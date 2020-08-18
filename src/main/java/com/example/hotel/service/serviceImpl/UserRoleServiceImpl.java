package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.UserroleMapper;
import com.example.hotel.model.Userrole;
import com.example.hotel.model.UserroleExample;
import com.example.hotel.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserroleMapper userroleMapper;
    @Override
    public int addUserRole(Userrole userRole) {
        return userroleMapper.insert(userRole);
    }

    @Override
    public int deleteUserRoleByUid(int id) {
        UserroleExample example=new UserroleExample();
        UserroleExample.Criteria criteria=example.createCriteria();
        criteria.andUidEqualTo(id);
        return userroleMapper.deleteByExample(example);
    }

    @Override
    public int updateUserRoleByUid(Userrole userrole) {
        UserroleExample example=new UserroleExample();
        UserroleExample.Criteria criteria=example.createCriteria();
        criteria.andUidEqualTo(userrole.getUid());
        return userroleMapper.updateByExampleSelective(userrole,example);
    }

    @Override
    public List<Userrole> getAllUserRole() {
        UserroleExample example=new UserroleExample();
        return userroleMapper.selectByExample(example);
    }
}
