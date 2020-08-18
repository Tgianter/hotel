package com.example.hotel.service;

import com.example.hotel.model.Permission;

import java.util.List;

public interface PermissionService {

    int addPermission(Permission permission);
    int deleteById(int id);
    int updatePermission(Permission permission);
    Permission selectById(int id);
    List<Permission> getAllPermission();
}
