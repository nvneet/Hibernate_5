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
			
			Address address1 = new Address();
			address1.setStreet("Monga Beach Road");
			address1.setCity("Mangalore");
			address1.setState("Karnataka");
			address1.setPincode(530039L);
			
			Address address2 = new Address();
			address2.setStreet("Riga");
			address2.setCity("Nalanda");
			address2.setState("Bihar");
			address2.setPincode(813326L);
			
			employee.getAddressList().add(address1);
			employee.getAddressList().add(address2);
			
			session.persist(employee);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}