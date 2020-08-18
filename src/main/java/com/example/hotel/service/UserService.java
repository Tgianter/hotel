package com.example.hotel.service;

import com.example.hotel.model.Permission;
import com.example.hotel.model.Role;
import com.example.hotel.model.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);
    List<Role> getRolesByName(String name);
    List<Role> listAllRole();
    List<Permission> getPermissionByName(String name);
    List<Permission> listAllPermission();
    List<User> getAllUser();
    User getUserById(int id);
    int deleteById(int id);
    int addUser(User user);
    int updateUser(User user);
}
