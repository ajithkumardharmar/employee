package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.impl.EmployeesImpl;
import com.employee.model.Employee;

@WebServlet("/viewEmployee")
public class ListAllEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeesImpl employeeImpl = new EmployeesImpl();
		System.out.println("hlo");
		List<Employee> employeeDetails = employeeImpl.getAllEmployee();
		HttpSession session = req.getSession();
		session.setAttribute("employeeDetails", employeeDetails);
		System.out.println(employeeDetails);
		resp.sendRedirect("employeeList.jsp");
	}

}
