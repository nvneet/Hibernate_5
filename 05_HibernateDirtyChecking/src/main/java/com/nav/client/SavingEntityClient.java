package com.nav.client;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.Session;

import com.nav.entities.Employee;
import com.nav.util.HibernateUtil;

public class SavingEntityClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Employee employee = session.get(Employee.class, 1);
			
			if(employee!=null) {
				session.beginTransaction();
				employee.setSalary(66600.00); // Dirty checking is firing update query even if update method is not called.
//				session.update(employee);
				session.getTransaction().commit();
			} else {
				System.out.println("employee doesn't exist");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
