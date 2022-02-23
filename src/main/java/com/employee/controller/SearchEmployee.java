package com.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.handler.EmployeeHandler;

@WebServlet("/searchEmp")
public class SearchEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeHandler emloyeeHandler = new EmployeeHandler();
		emloyeeHandler.searchEmployee(req);
		resp.sendRedirect("employeeList.jsp");
		// LocalDate joiningDateTo = LocalDate.parse(joiningDate1);
		// System.out.println(empCode + empCity + empState + joiningDateFrom +
		// joiningDateTo);

	}

}
