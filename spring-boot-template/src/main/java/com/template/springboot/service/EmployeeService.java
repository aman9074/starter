package com.template.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.springboot.dao.IEmployeeDAO;
import com.template.springboot.model.Employee;
import com.template.springboot.model.Employees;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeDAO employeeDao;
	
	@Override
	public int createEmployee(Employee employee) {
		Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
        employeeDao.addEmployee(employee);
		return id;
	}

	@Override
	public Employees getEmployees() {
		return employeeDao.getAllEmployees();
	}

}
