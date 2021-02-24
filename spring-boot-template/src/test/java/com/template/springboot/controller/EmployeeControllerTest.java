package com.template.springboot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.template.springboot.model.Employee;
import com.template.springboot.model.Employees;

/*
 * Reference: https://howtodoinjava.com/spring-boot2/testing/junit5-with-spring-boot2/
 */
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testGetEmployeeListSuccessWithHeaders() throws URISyntaxException 
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-LOCATION", "USA");

		HttpEntity<Employee> requestEntity = new HttpEntity<>(null, headers);

		try
		{
			ResponseEntity<Employees> listEmployeesResponse = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Employees.class);
			assertEquals(HttpStatus.OK, listEmployeesResponse.getStatusCode());
			assertFalse(listEmployeesResponse.getBody().getEmployeeList().isEmpty());
		}
		catch(HttpClientErrorException ex) 
		{
			//Verify bad request and missing header
			assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
		}
	}
}
