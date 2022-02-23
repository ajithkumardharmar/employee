package com.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.handler.EmployeeHandler;

@WebServlet("/addEmp")
public class AddEmployeeDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeHandler employeeHandler = new EmployeeHandler();
		int i = employeeHandler.addEmployeeHandler(req);
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
