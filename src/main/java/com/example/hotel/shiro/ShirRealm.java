package com.example.hotel.shiro;

import com.example.hotel.model.Permission;
import com.example.hotel.model.Role;
import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
import com.example.hotel.util.TransferToSetString;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class ShirRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Autowired
    TransferToSetString transfer;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user= (User) principalCollection.getPrimaryPrincipal();
        String userName=user.getUsername();
        List<Role> roles=userService.getRolesByName(userName);
        Set<String> roleSet=transfer.transferRole(roles);
        List<Permission> permissions=userService.getPermissionByName(userName);
        Set<String> permissionSet=transfer.transferPermission(permissions);
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addRoles(roleSet);
        info.addStringPermissions(permissionSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name=token.getPrincipal().toString();
        User user =userService.getUserByName(name);
        if(null==user){
            return null;
        }
        String salt=user.getSalt();
        String DBPassword=user.getPassword();
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
          user,DBPassword, ByteSource.Util.bytes(salt),getName()
        );
        return info;
    }
}
