package com.nav.client;

import org.hibernate.Session;

import com.nav.entities.Address;
import com.nav.entities.Employee;
import com.nav.util.HibernateUtil;

public class FetchDataClient {

	public static void main(String[] args) {
		getEmployeeAndAddressByEmployeeId();
		getEmployeeAndAddressByAddressId();
	}

	private static void getEmployeeAndAddressByEmployeeId() {
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			employee = session.get(Employee.class, 1);
			/* Equivalent query
			 * 
			 * select * from employee employee0 left outer join address address1 
			 *			on employee0.address_id=address1.address_id 
			 *			where employee0_.employeeId=?
			 */
			
			System.out.println("employee:  "+ employee);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getEmployeeAndAddressByAddressId() {
		Address address = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			address = session.get(Address.class, 1);
			
			/* Equivalent query
			 * 
			 * select * from address address0 left outer join employee employee1 
			 *			on address0.address_id=employee1.address_id 
			 *			where address0.address_id=1
			 * 
			 */
			
			System.out.println("address:  "+ address);
			System.out.println("employee:  "+ address.getEmployee());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
