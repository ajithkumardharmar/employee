package com.employee.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchEmp")
public class SearchEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empCode = Integer.parseInt(req.getParameter("empCode"));
		String empCity = req.getParameter("empCity");
		String empState = req.getParameter("empState");
		String localDate = req.getParameter("dateOfBirth");
		LocalDate joiningDateFrom = LocalDate.parse(localDate);
		String joiningDate1 = req.getParameter("joiningDate");
		LocalDate joiningDateTo = LocalDate.parse(joiningDate1);
		System.out.println(empCode + empCity + empState + joiningDateFrom + joiningDateTo);

	}

}
