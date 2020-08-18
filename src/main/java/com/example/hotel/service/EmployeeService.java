package com.example.hotel.service;

import com.example.hotel.model.Employee;

import java.util.List;

public interface EmployeeService {

    int addEmployee(Employee employee);
    int deleteEmployeeById(String id);
    int updateEmployee(Employee employee);
    Employee getEmployeeById(String id);
    List<Employee> getAllEmployee();
}
