package com.nav.client;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.Session;

import com.nav.entities.Employee;
import com.nav.model.Address;
import com.nav.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			createEmployee(session);
			
		} catch (Exception e) {
			e.printStackTrace();
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
		
		Address officeAddress = new Address();
		officeAddress.setStreet("Monga Beach Road");
		officeAddress.setCity("Mangalore");
		officeAddress.setState("Karnataka");
		officeAddress.setPincode(530039L);
		
		Address homeAddress = new Address();
		homeAddress.setStreet("Triveni Ghat Road");
		homeAddress.setCity("Dehradun");
		homeAddress.setState("Uttarakhand");
		homeAddress.setPincode(326512L);
		
		employee.setOfficeAddress(officeAddress);
		employee.setHomeAddress(homeAddress);
		return employee;
	}
}
