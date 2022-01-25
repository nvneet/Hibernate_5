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
			Employee employee = getEmployee1();
			session.beginTransaction();
			
			// table gets dropped and created again, previous record lost.
//			session.persist(employee);   // return type is void, throws exception with existing primary key
			session.persist(getEmployee1());
			
			Integer id = (Integer) session.save(getEmployee2()); // return type is serializable
			System.out.println("Employee 2 is created with id: " + id);
			session.getTransaction().commit();
			
			session.saveOrUpdate(getEmployee3());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Employee getEmployee1() {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		
		Employee employee = new Employee();
		employee.setEmployeeName("Mukesh");
		employee.setEmail("Mukesh@facebook.com");
		employee.setSalary(32000.00);
//		employee.setDoj(new Date());
		employee.setDoj(out);
		
		return employee;
	}
	
	private static Employee getEmployee2() {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		
		Employee employee = new Employee();
		employee.setEmployeeName("Ratnesh");
		employee.setEmail("Ratnesh@yahoo.com");
		employee.setSalary(45000.00);
//		employee.setDoj(new Date());
		employee.setDoj(out);
		
		return employee;
	}
	
	private static Employee getEmployee3() {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		
		Employee employee = new Employee();
		employee.setEmployeeName("Jeevan");
		employee.setEmail("Jeevan@apple.com");
		employee.setSalary(23000.00);
//		employee.setDoj(new Date());
		employee.setDoj(out);
		
		return employee;
	}

}
