package com.nav.client;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.Session;

import com.nav.entities.Employee;
import com.nav.service.EmployeeService;
import com.nav.service.impl.EmployeeServiceImpl;
import com.nav.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		createEmployee(employeeService);
		getEmployeeById(employeeService, 1);
		updateEmployeeById(employeeService, 1);
		deleteEmployeeById(employeeService, 2);
	}
	
	private static void getEmployeeById(EmployeeService employeeService, int id) {		
		employeeService.getEmployeeById(id);
	}

	private static void createEmployee(EmployeeService employeeService) {
		employeeService.createEmployee(getEmployee());
	}

	private static void updateEmployeeById(EmployeeService employeeService, int id) {
		employeeService.updateEmployeeById(id);
	}
	
	private static void deleteEmployeeById(EmployeeService employeeService, int id) {
		employeeService.deleteEmployeeById(id);
	}
	
	private static Employee getEmployee() {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		
		Employee employee = new Employee();
		employee.setEmployeeName("Ramesh");
		employee.setEmail("Ramesh@facebook.com");
		employee.setSalary(50000.00);
//		employee.setDoj(new Date());
		employee.setDoj(out);
		
		return employee;
	}
}
