package com.fenuk.example.main;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fenuk.example.dao.EmployeeDao;
import com.fenuk.example.model.Employee;

public class App {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean(EmployeeDao.class);
		
		for (int i = 0; i<10;  i++){
			
			String name = RandomStringUtils.randomAlphabetic(5);
			long salary = RandomUtils.nextLong(0, 10000);
			
			dao.saveEmployee(new Employee(name, salary));
			Employee e = dao.getEmployeeByName(name);

			System.out.println(e);
			
		}
		
	}

}
