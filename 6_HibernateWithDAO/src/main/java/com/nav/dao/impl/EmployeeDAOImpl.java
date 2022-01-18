package com.nav.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nav.dao.EmployeeDAO;
import com.nav.entities.Employee;
import com.nav.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee employee) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			Integer id = (Integer) session.save(employee); 
			session.getTransaction().commit();
		} catch (HibernateException e)	{
			e.printStackTrace();
		}
	}

	@Override
	public Employee fetchEmployeeById(int employeeId) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			Employee employee = session.get(Employee.class, employeeId);
			
			if(employee!=null) {
				System.out.println(employee);
				return employee;
			}  else System.out.println("Employee doesnt exist");			
		} catch (HibernateException e)	{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateEmployeeById(int employeeId) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Employee employee = session.get(Employee.class, employeeId);
			session.beginTransaction();
			employee.setSalary(105.00);
			session.update(employee);
			session.getTransaction().commit();
		} catch (HibernateException e)	{
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteEmployeeById(int employeeId) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Employee employee = session.get(Employee.class, employeeId);
			if (employee!=null) {
				session.beginTransaction();
				session.delete(employee);
				session.getTransaction().commit();
			} else {
				System.out.println("Employee doesnt exist.");
			}
			
		} catch (HibernateException e)	{
			e.printStackTrace();
		}		
	}

}
