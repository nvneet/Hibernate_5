package com.nav.service.impl;

import com.nav.dao.impl.EmployeeDAOImpl;
import com.nav.entities.Employee;
import com.nav.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void createEmployee(Employee employee) {
		new EmployeeDAOImpl().addEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return new EmployeeDAOImpl().fetchEmployeeById(employeeId);
	}

	@Override
	public void updateEmployeeById(int employeeId) {
		new EmployeeDAOImpl().updateEmployeeById(employeeId);
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		new EmployeeDAOImpl().deleteEmployeeById(employeeId);
	}

}
