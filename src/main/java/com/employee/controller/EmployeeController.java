package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.handler.EmployeeHandler;
import com.employee.model.Employee;

@RestController
public class EmployeeController {

	@RequestMapping("/viewEmployee")
	public ModelAndView listEmployee(HttpServletRequest req) {

		EmployeeHandler employeeHandler = new EmployeeHandler();
		ModelAndView mv = employeeHandler.listAllEmployeeHandler(req);
		return mv;

	}

	@PostMapping("/addEmp")
	public ModelAndView addEmployee(HttpServletRequest req) {
		EmployeeHandler employeeHandler = new EmployeeHandler();
		int i = employeeHandler.addEmployeeHandler(req);
		ModelAndView mv = new ModelAndView();
		if (i > 0) {
			System.out.println("success");
			mv.setViewName("employee.jsp");
		} else {
			System.out.println("not valid");
			mv.setViewName("employee.jsp");
		}
		return mv;
	}

	@PostMapping("searchEmp")
	public ModelAndView searchEmp(HttpServletRequest req) {
		EmployeeHandler emloyeeHandler = new EmployeeHandler();
		emloyeeHandler.searchEmployee(req);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeeList.jsp");
		return mv;
	}

	@RequestMapping("searchOne")
	public ModelAndView searchOne(HttpServletRequest req) {
		EmployeeHandler emloyeeHandler = new EmployeeHandler();
		List<Employee> employeeList = emloyeeHandler.searchEmployeeOne(req);
		ModelAndView mv = new ModelAndView();
		mv.addObject("employeeList", employeeList);
		mv.setViewName("employee.jsp");
		return mv;
	}

}
