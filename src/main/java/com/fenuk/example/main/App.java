package com.fenuk.example.main;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fenuk.example.model.Employee;
import com.fenuk.example.repository.EmployeeJdbcRepository;

public class App {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeJdbcRepository employeeRepository = (EmployeeJdbcRepository) context
				.getBean(EmployeeJdbcRepository.class);

		for (int i = 0; i < 10; i++) {
			String name = RandomStringUtils.randomAlphabetic(10);
			long salary = RandomUtils.nextLong(0, 100000);
			Employee e = new Employee(name, salary);
			employeeRepository.save(e);
			
			e = employeeRepository.getByName(name);

			System.out.println(i + ": " + e);
		}

	}

}
