package com.example.hotel.service;

import com.example.hotel.model.Role;

import java.util.List;

public interface RoleServiceImpl {
    int addRole(Role role);
    Role selectById(int id);
    List<Role> getAllRole();
    int deleteById(int id);
    int updateById(Role role);
}
