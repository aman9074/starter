package com.template.springboot.dao;

import org.springframework.stereotype.Repository;

import com.template.springboot.model.Employee;
import com.template.springboot.model.Employees;

@Repository
public class EmployeeDAO implements IEmployeeDAO
{
	private static Employees list = new Employees();

	static
	{
		list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
		list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
		list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
	}

	@Override
	public void addEmployee(Employee employee) {
		list.getEmployeeList().add(employee);
	}
	
	@Override
	public Employees getAllEmployees() 
	{
		return list;
	}
}
