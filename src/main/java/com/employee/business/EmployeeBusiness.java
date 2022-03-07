package com.employee.business;

import java.util.List;

import com.employee.impl.EmployeesImpl;
import com.employee.model.Employee;

public class EmployeeBusiness {

	public List<Employee> searchEmployee(Employee employee) {
		EmployeesImpl employeeImpl = new EmployeesImpl();
		List<Employee> emplist = employeeImpl.searchEmployee(employee);
		return emplist;
	}

	public int addEmployee(Employee employee) {
		EmployeesImpl employeeImpl = new EmployeesImpl();
		int i = employeeImpl.addEmployee(employee);
		return i;

	}

	public List<Employee> getAllEmployee() {
		EmployeesImpl employeeImpl = new EmployeesImpl();
		List<Employee> employeeDetails = employeeImpl.getAllEmployee();
		return employeeDetails;
	}

}
