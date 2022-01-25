package com.nav.service;

import com.nav.entities.Employee;

public interface EmployeeService {
	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(int employeeId);
	public abstract void updateEmployeeById(int employeeId);
	public abstract void deleteEmployeeById(int employeeId);
}
