package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.RoleMapper;
import com.example.hotel.model.Role;
import com.example.hotel.model.RoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements com.example.hotel.service.RoleServiceImpl {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public Role selectById(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> getAllRole() {
        RoleExample example =new RoleExample();
        example.setOrderByClause("id asc");
        return roleMapper.selectByExample(example);
    }

    @Override
    public int deleteById(int id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }
}
