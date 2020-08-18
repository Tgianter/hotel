package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.RolepermissionMapper;
import com.example.hotel.model.Rolepermission;
import com.example.hotel.model.RolepermissionExample;
import com.example.hotel.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    RolepermissionMapper rolepermissionMapper;
    @Override
    public int addRolePermission(Rolepermission rolePermission) {
        return rolepermissionMapper.insert(rolePermission);
    }

    @Override
    public int deleteByRid(int rid) {
        RolepermissionExample example =new RolepermissionExample();
        RolepermissionExample.Criteria criteria=example.createCriteria();
        criteria.andRidEqualTo(rid);
        return rolepermissionMapper.deleteByExample(example);
    }

    @Override
    public int updateRolePermission(Rolepermission rolePermission) {
        RolepermissionExample example=new RolepermissionExample();
        RolepermissionExample.Criteria criteria=example.createCriteria();
        criteria.andRidEqualTo(rolePermission.getRid());
        return rolepermissionMapper.updateByExampleSelective(rolePermission,example);
    }

    @Override
    public List<Rolepermission> getAllRolePermission() {
        RolepermissionExample example=new RolepermissionExample();
        return rolepermissionMapper.selectByExample(example);
    }
}
