package com.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.handler.EmployeeHandler;

@WebServlet("/viewEmployee")
public class ListAllEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeHandler employeeHandler = new EmployeeHandler();
		employeeHandler.listAllEmployeeHandler(req);
		resp.sendRedirect("employeeList.jsp");
	}

}
