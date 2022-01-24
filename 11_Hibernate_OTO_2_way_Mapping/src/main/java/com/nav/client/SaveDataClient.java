package com.nav.client;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.Session;

import com.nav.entities.Employee;
import com.nav.entities.Address;
import com.nav.util.HibernateUtil;

public class SaveDataClient {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			Employee employee = new Employee();
			employee.setEmployeeName("Ramesh");
			employee.setEmail("Ramesh@facebook.com");
			employee.setSalary(50000.00);
			employee.setDoj(new Date());
			
			Address address = new Address();
			address.setStreet("Monga Beach Road");
			address.setCity("Mangalore");
			address.setState("Karnataka");
			address.setPincode(530039L);
			
			employee.setAddress(address);
//			Integer id = (Integer) session.save(employee);
			
//			session.save(employee); // This is to execute query without cascade 
//			session.save(address);  // in parent entity class. But it runs 3 query.
			
			// To save from 3 query use persist cascade type in Entity class
			session.persist(employee);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}