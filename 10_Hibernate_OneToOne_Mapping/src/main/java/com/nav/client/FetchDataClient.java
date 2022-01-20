package com.nav.client;

import org.hibernate.Session;

import com.nav.entities.Address;
import com.nav.entities.Employee;
import com.nav.util.HibernateUtil;

public class FetchDataClient {

	public static void main(String[] args) {
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			employee = session.get(Employee.class, 1);
			
			System.out.println("employee:  "+ employee); // address not available in employee object here
			
			if (employee != null) {
				Address address = employee.getAddress();
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
