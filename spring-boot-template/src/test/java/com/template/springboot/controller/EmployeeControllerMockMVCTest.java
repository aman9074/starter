package com.template.springboot.controller;

	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.template.springboot.model.Employee;
import com.template.springboot.model.Employees;
import com.template.springboot.service.IEmployeeService;

public class EmployeeControllerMockMVCTest extends AbstractTest {

	@MockBean
    private IEmployeeService employeeService;
	
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getEmployeesList() throws Exception {
		// Setup our mocked service
        Employee employee1 = new Employee(1, "First Name", "Last Name", "email");
        Employee employee2 = new Employee(2, "First Name", "Last Name", "email");
        Employees employees = new Employees();
        employees.setEmployeeList(Arrays.asList(employee1, employee2));
        doReturn(employees).when(employeeService).getEmployees();

		String uri = "/employees";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		Employees employeesResponse = super.mapFromJson(content, Employees.class);
		assertFalse(employeesResponse.getEmployeeList().isEmpty());
		assertEquals(employee1.getId(), employeesResponse.getEmployeeList().get(0).getId());
	}
}
