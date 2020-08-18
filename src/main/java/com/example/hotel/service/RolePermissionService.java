package com.example.hotel.service;

import com.example.hotel.model.Rolepermission;

import java.util.List;

public interface RolePermissionService {
    int addRolePermission(Rolepermission rolePermission);
    int deleteByRid(int id);
    int updateRolePermission(Rolepermission rolePermission);
    List<Rolepermission> getAllRolePermission();
}
