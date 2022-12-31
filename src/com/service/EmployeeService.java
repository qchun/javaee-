package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.bean.User;
import com.dao.EmployeeDao;
import com.dao.UserDao;

@Service("employeeService")
public class EmployeeService {
	@Resource(name="employeeDao")		//@Autowired
	EmployeeDao employeedao;
	
	
	public List<Employee> selectEmployee(Map m){
		return employeedao.selectEmployee(m);
	}
	
	public int selectEmployeeCount(Employee e){
		return employeedao.selectEmployeeCount(e);
	}
	
	public int addEmployee(Employee e){
		return employeedao.addEmployee(e);
	}
	
	public int deleteEmployee(int id){
		return employeedao.deleteEmployee(id);
	}
	
	public void deleteEmployees(int[] ids){
		for(int i=0;i<ids.length;i++){
			employeedao.deleteEmployee(ids[i]);
		}
	}
	
	public Employee selectEmployeeById(int id){
		return employeedao.selectEmployeeById(id);
	}
	
	public int updateEmployee(Employee e){
		return employeedao.updateEmployee(e);
	}
}
