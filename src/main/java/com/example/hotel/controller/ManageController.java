package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.model.*;
import com.example.hotel.service.*;
import com.example.hotel.util.UserHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;
    @Autowired
    UserHelper userHelper;

    @DeleteMapping("/deleteUser")
    public int deleteUserById(int id){
        return userService.deleteById(id);
    }
    @PostMapping("/addUser")
    public int addUser(String user){
        User target=JSON.parseObject(user,User.class);
        if(target.getUsername().equals("")||target.getPassword().equals("")){
            return 0;
        }else{
            User newUser=userHelper.transferUser(target);
            return userService.addUser(newUser);
        }
    }
    @GetMapping("/getAllUser")
    public PageInfo<User> getAllUser(int start){
        PageHelper.startPage(start,4);
        List<User> list=userService.getAllUser();
        return new PageInfo<>(list);
    }
//    @GetMapping("/getAllUser")
//    public PageInfo<User> getAllUser(){
//        PageHelper.startPage(1,5);
//        List<User> list=userService.getAllUser();
//        return new PageInfo<>(list);
//    }
    @PostMapping("/addUserRole")
    public int addUserRole( String userrole){
        Userrole target= JSON.parseObject(userrole,Userrole.class);
        if(target==null||target.getUid()==0||target.getRid()==0){
            return 0;
        }else{
            return userRoleService.addUserRole(target);
        }
    }

    @DeleteMapping("/deleteUserRoleByUid")
    public int deleteUserRole(int uid) {
        return userRoleService.deleteUserRoleByUid(uid);
    }
    @GetMapping("/getAllUserRole")
    public PageInfo<Userrole> getAllUserRole(Integer start){
        PageHelper.startPage(start,4);
        List <Userrole> list=userRoleService.getAllUserRole();
        return new PageInfo<>(list);
    }
    @PostMapping("/addRolePermission")
    public int addRolePermission(String rolepermission){
        Rolepermission target=JSON.parseObject(rolepermission,Rolepermission.class);
        if(target.getRid()==0||target.getPid()==0){
            return 0;
        }else{
            return rolePermissionService.addRolePermission(target);
        }
    }

    @DeleteMapping("/deleteRolePermissionByRid")
    public int deleteRolePermissionByRid(int rid){
        return rolePermissionService.deleteByRid(rid);
    }
    @GetMapping("/getAllRolePermission")
    public PageInfo<Rolepermission> getAllRolePermission(Integer start){
        if(null==start){
            PageHelper.startPage(1,4);
        }else {
            PageHelper.startPage(start,4);

        }
//        RolepermissionExample example=new RolepermissionExample();
        List<Rolepermission> list=rolePermissionService.getAllRolePermission();
        return new PageInfo<>(list);
    }
    @PostMapping("/addRole")
    public int addRole(String role){
        Role target=JSON.parseObject(role,Role.class);
        if(target.getName().equals("")){
            return 0;
        }else{
            return roleService.addRole(target);
        }
    }

    @DeleteMapping("/deleteRole")
    public int deleteRole(int id){
        return roleService.deleteById(id);
    }
    @GetMapping("/getAllRole")
    public PageInfo<Role> getAllRole(int start){
        PageHelper.startPage(start,4);
        List<Role> list=roleService.getAllRole();
        return new PageInfo<>(list);
    }

    @PostMapping("/addPermission")
    public int addPermission(String permission){
        Permission target=JSON.parseObject(permission,Permission.class);
        if(target.getName().equals("")){
            return 0;
        }else{
            return permissionService.addPermission(target);
        }
    }

    @DeleteMapping("/deletePermission")
    public int deletePermission(int id){
        return permissionService.deleteById(id);
    }
    @GetMapping("/getAllPermission")
    public PageInfo<Permission> getAllPermission(Integer start){
        PageHelper.startPage(start,4);
        List<Permission> list=permissionService.getAllPermission();
        return new PageInfo<>(list);
    }

}
