package com.template.springboot.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.template.springboot.model.Employee;
import com.template.springboot.model.Employees;
import com.template.springboot.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController 
{
	@Autowired
	private IEmployeeService employeeService;
     
    @GetMapping
    public ResponseEntity<Employees> getEmployees() 
    {
    	return new ResponseEntity<Employees>(employeeService.getEmployees(), new HttpHeaders(), HttpStatus.OK);
    }
     
    @PostMapping
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) 
    {
        Integer id = employeeService.createEmployee(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(id)
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}
