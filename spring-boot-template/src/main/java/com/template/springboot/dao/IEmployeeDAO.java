package com.template.springboot.dao;

import com.template.springboot.model.Employee;
import com.template.springboot.model.Employees;

public interface IEmployeeDAO {

	void addEmployee(Employee employee);
	
	Employees getAllEmployees();
}
