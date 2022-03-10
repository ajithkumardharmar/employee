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
		String empName = employeeImpl.checkOneEmployee(employee);
		int i = 0;
//		 = employeeDetails.get(0).getEmpName();
		if (empName == null) {
			i = employeeImpl.addEmployee(employee);
			System.out.println("insert");
		} else {
			i = employeeImpl.updateEmployee(employee);
			System.out.println("update");
		}

		return i;

	}

	public List<Employee> getAllEmployee() {
		EmployeesImpl employeeImpl = new EmployeesImpl();
		List<Employee> employeeDetails = employeeImpl.getAllEmployee();
		return employeeDetails;
	}

	public List<Employee> searchOne(Employee employee) {
		EmployeesImpl employeeImpl = new EmployeesImpl();
		List<Employee> employeeDetails = employeeImpl.getOneEmployee(employee);
		return employeeDetails;
	}

}
