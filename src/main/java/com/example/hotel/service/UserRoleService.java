package com.example.hotel.service;

import com.example.hotel.model.Userrole;

import java.util.List;

public interface UserRoleService {

    int addUserRole(Userrole userRole);
    int deleteUserRoleByUid(int id);
    int updateUserRoleByUid(Userrole UserRole);
    List<Userrole> getAllUserRole();
}
