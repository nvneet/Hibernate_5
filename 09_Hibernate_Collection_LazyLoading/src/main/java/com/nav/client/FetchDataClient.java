package com.nav.client;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.Session;

import com.nav.entities.Employee;
import com.nav.model.Address;
import com.nav.util.HibernateUtil;

public class FetchDataClient {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Employee employee = session.get(Employee.class, 1);
			
			System.out.println("employee:  "+ employee); // address not available in employee object here
			if (employee != null) {
				employee.getAddressList().forEach(System.out::println); // getting Address from employee object // Lazy loading
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
