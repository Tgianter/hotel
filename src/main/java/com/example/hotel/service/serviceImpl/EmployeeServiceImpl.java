package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.EmployeeMapper;
import com.example.hotel.model.Employee;
import com.example.hotel.model.EmployeeExample;
import com.example.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public int deleteEmployeeById(String id) {
        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        return employeeMapper.deleteByExample(example);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Employee> employees=employeeMapper.selectByExample(example);
        if(employees.size()<1){
            return null;
        }else{
            return employees.get(0);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        EmployeeExample example= new EmployeeExample();
        example.setOrderByClause("tid asc");
        return employeeMapper.selectByExample(example);
    }
}
