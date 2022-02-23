package com.employee.handler;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.employee.impl.EmployeesImpl;
import com.employee.model.Employee;

public class EmployeeHandler {

	public int addEmployeeHandler(HttpServletRequest req) {
		int empCode = Integer.parseInt(req.getParameter("empCode"));
		String empName = req.getParameter("empName");
		String email = req.getParameter("empEmail");
		String address1 = req.getParameter("empAddress1");
		String address2 = req.getParameter("empAddress2");
		String empCity = req.getParameter("empCity");
		String empState = req.getParameter("empState");
		String localDate = req.getParameter("dateOfBirth");
		LocalDate dateOfBirth = LocalDate.parse(localDate);
		String joiningDate1 = req.getParameter("joiningDate");
		LocalDate joiningDate = LocalDate.parse(joiningDate1);
		System.out.println(
				empCode + empName + email + address1 + address2 + empCity + empState + dateOfBirth + joiningDate);
		Employee employee = new Employee(empCode, empName, email, address1, address2, empCity, empState, dateOfBirth,
				joiningDate);
		EmployeesImpl employeeImpl = new EmployeesImpl();
		int i = employeeImpl.addEmployee(employee);
		return i;

	}

	public void listAllEmployeeHandler(HttpServletRequest req) {
		EmployeesImpl employeeImpl = new EmployeesImpl();
		System.out.println("hlo");
		List<Employee> employeeDetails = employeeImpl.getAllEmployee();
		HttpSession session = req.getSession();
		session.setAttribute("employeeDetails", employeeDetails);

	}

	public void searchEmployee(HttpServletRequest req) {
		String empCodes = null;
		empCodes = req.getParameter("sempCode");

		System.out.println("hlo" + empCodes);
		int empCode = 0;
		System.out.println(empCodes);
		if (!empCodes.equals("")) {
			System.out.println(empCodes.equals(""));
			System.out.println("empCodes");
			empCode = Integer.parseInt(empCodes);
		}
		String empCity = req.getParameter("sempCity");
		System.out.println(empCity);
		String empState = req.getParameter("sempState");
		System.out.println(empState);
		String localDate = req.getParameter("sfromDate");
		System.out.println(localDate);
		LocalDate joiningDateFrom = null;
		if (!localDate.equals("")) {
			joiningDateFrom = LocalDate.parse(localDate);
		}
		String joiningDate1 = req.getParameter("stoDate");
		LocalDate joiningDateTo = null;
		if (!joiningDate1.equals("")) {
			joiningDateTo = LocalDate.parse(joiningDate1);
		}
		System.out.println(joiningDate1);
		Employee employee = new Employee(empCode, empCity, empState, joiningDateFrom, joiningDateTo);

		EmployeesImpl employeeImpl = new EmployeesImpl();
		List<Employee> emplist = employeeImpl.searchEmployee(employee);
		System.out.println(emplist);
		HttpSession session = req.getSession();
		session.setAttribute("employeeDetails", emplist);

	}

}
