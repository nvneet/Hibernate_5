package com.nav.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
	
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		// Creating StandardServiceRegistryBuilder
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
		
		// Hibernate settings which is equivalent to hibernate.cfg.xml's properties
		Map<String,String> dbSettings = new HashMap<>();
		dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/apartmentdb");
		dbSettings.put(Environment.USER, "root");
		dbSettings.put(Environment.PASS, "pass9");
		dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		
		// Apply database settings
		registryBuilder.applySettings(dbSettings);
		
		// Creating registry
		standardServiceRegistry = registryBuilder.build();
		
		// Creating MetadataSources
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		
		// Creating metadata
		Metadata metadata = metadataSources.getMetadataBuilder().build();
		
		// creating SessionFactory
		sessionFactory = metadata.getSessionFactoryBuilder().build();
/*	
		try {
			if(sessionFactory == null)
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			e.printStackTrace();
			if (standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}
*/
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
