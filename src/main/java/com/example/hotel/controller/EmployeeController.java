package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.model.Employee;
import com.example.hotel.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public int addEmployee(String employee){
        Employee target= JSON.parseObject(employee,Employee.class);
        if(target.getId().equals("") || target.getName().equals("")||target.getPhonenumber().equals("")){
            return 0;
        }else{
//            log.info(target.getId());
            return employeeService.addEmployee(target);
        }
    }
    @DeleteMapping("/deleteEmployee")
    public int deleteEmployee(@RequestParam("id") String id){
        return employeeService.deleteEmployeeById(id);
    }
    @PostMapping("/updateEmployee")
    public int updateEmployee(String employee){
        Employee target=JSON.parseObject(employee,Employee.class);
        if(target.getId().equals("") || target.getName().equals("")||target.getPhonenumber().equals("")){
            return 0;
        }else{
//            log.info(target.getId());
            return employeeService.updateEmployee(target);
        }

    }
    @GetMapping("/getEmployee")
    public Employee getEmployee(@RequestParam("id") String id ){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/getAllEmployee")
    public PageInfo<Employee> getAllEmployee(int start){
        PageHelper.startPage(start,4);
        List<Employee> list=employeeService.getAllEmployee();
        return new PageInfo<>(list);
    }
}
