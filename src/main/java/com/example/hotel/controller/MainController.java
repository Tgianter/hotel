package com.example.hotel.controller;

import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
import com.example.hotel.util.UserHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    UserHelper userHelper;
    @PostMapping("/login")
    public String doLogin(@RequestParam String username,@RequestParam String password){
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            return "fail";
        } catch (UnknownAccountException uae) {
            return "fail";
        }

        return "success";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String password){
        User user=new User(username,password);
        user=userHelper.transferUser(user);

            userService.addUser(user);


        return "success";
    }
    @GetMapping("/index")
    public String index(){

        return "indexPage";
    }


}
