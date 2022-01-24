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
			
			System.out.println("employee:  "+ employee);

			// equivalent query :
//  select * from  employee employee1 left outer join address address1 
//  on employee1.address_id=address1.address_id where employee1.employeeId=1
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
