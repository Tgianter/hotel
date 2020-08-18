package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.PermissionMapper;
import com.example.hotel.model.Permission;
import com.example.hotel.model.PermissionExample;
import com.example.hotel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int deleteById(int id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePermission(Permission permission) {
        return permissionMapper.updateByPrimaryKey(permission);
    }

    @Override
    public Permission selectById(int id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> getAllPermission() {
        PermissionExample example =new PermissionExample();
        example.setOrderByClause("id asc");
        return permissionMapper.selectByExample(example);
    }
}
