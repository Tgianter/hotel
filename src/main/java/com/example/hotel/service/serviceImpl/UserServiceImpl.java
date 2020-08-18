package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.UserMapper;
import com.example.hotel.model.Permission;
import com.example.hotel.model.Role;
import com.example.hotel.model.User;
import com.example.hotel.model.UserExample;
import com.example.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<User> users=userMapper.selectByExample(example);
        if(users.size()<1){
            return null;
        }else{
            return users.get(0);
        }
    }

    @Override
    public List<Role> getRolesByName(String name) {
        List<User> list=userMapper.getRolesOfUser(name);
        List<Role> roles=new ArrayList<>();
        for(User u: list ){
            roles.addAll(u.getRoles());
        }
        return roles;
    }

    @Override
    public List<Role> listAllRole() {
        List<User> list=userMapper.listAllRole();
        List<Role> roles=new ArrayList<>();
        for(User u: list ){
            roles.addAll(u.getRoles());
        }
        return roles;
    }

    @Override
    public List<Permission> getPermissionByName(String name) {
        List<User> list=userMapper.getPermissionsOfUser(name);
        List<Permission> permissions=new ArrayList<>();
        for(User u:list){
            permissions.addAll(u.getPermissions());
        }
        return permissions;
    }

    @Override
    public List<Permission> listAllPermission() {
        List<User> list=userMapper.listAllPermission();
        List<Permission> permissions=new ArrayList<>();
        for(User u:list){
            permissions.addAll(u.getPermissions());
        }
        return permissions;
}

    @Override
    public List<User> getAllUser() {
        UserExample example =new UserExample();
        example.setOrderByClause("id asc");
        return userMapper.selectByExample(example);
    }

    @Override
    public User getUserById(int id) {
//        UserExample example=new UserExample();

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
