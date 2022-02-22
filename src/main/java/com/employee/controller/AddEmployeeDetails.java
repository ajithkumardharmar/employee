package com.employee.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.impl.EmployeesImpl;
import com.employee.model.Employee;

@WebServlet("/addEmp")
public class AddEmployeeDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		System.out.println("hlo" + i);
		if (i > 0) {
			System.out.println("success");
			resp.sendRedirect("employee.jsp");
		} else {
			System.out.println("not valid");
			resp.sendRedirect("employee.jsp");
		}

	}
}
