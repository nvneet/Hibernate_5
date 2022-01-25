package com.nav.client;

import org.hibernate.Session;

import com.nav.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "SELECT version();";
			String result = (String) session.createNativeQuery(sql).getSingleResult();
			
			System.out.println("MYSQL version is ::");
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
