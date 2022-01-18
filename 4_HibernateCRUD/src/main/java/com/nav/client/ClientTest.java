package com.nav.client;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.Session;

import com.nav.entities.Employee;
import com.nav.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
//			createEmployee(session);
//			getEmployeeById(session);
//			updateEmployeeById(session);
			deleteEmployeeById(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if (employee != null) {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Employee doesn't exist with provided Id - " + employee.getEmployeeId());
		}
	}

	private static void updateEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if (employee != null) {
			employee.setSalary(80000.00);
			
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Employee doesn't exist with provided Id - " + employee.getEmployeeId());
		}
	}

	private static void getEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if (employee != null) {
			System.out.println("Employee: " + employee);
		}
		else {
			System.out.println("Employee doesn't exist with provided Id - " + employee.getEmployeeId());
		}		
	}

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id = (Integer) session.save(getEmployee()); // return type is serializable
		System.out.println("Employee is created with id: " + id);
		session.getTransaction().commit();
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
