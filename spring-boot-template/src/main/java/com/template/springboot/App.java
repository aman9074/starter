package com.template.springboot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App 
{
    public static void main(String[] args)
    {
    	ApplicationContext applicationContext = SpringApplication.run(App.class, args);
    	List<String> allBeanNames = Arrays.asList(applicationContext.getBeanDefinitionNames());
    	Collections.sort(allBeanNames);
		System.out.println("Scanned bean names are:");
		for(String beanName : allBeanNames) {
			System.out.println(beanName);
		}
    }
}
