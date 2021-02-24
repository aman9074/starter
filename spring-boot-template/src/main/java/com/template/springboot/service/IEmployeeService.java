package com.template.springboot.service;

import com.template.springboot.model.Employee;
import com.template.springboot.model.Employees;

public interface IEmployeeService {

	int createEmployee(Employee employee);
	
	Employees getEmployees();
}
