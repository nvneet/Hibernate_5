package com.nav.dao;

import com.nav.entities.Employee;

public interface EmployeeDAO {

	public abstract void addEmployee(Employee employee);
	public abstract Employee fetchEmployeeById(int employeeId);
	public abstract void updateEmployeeById(int employeeId);
	public abstract void deleteEmployeeById(int employeeId);
}
