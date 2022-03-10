package com.employee.handler;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.employee.business.EmployeeBusiness;
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
		EmployeeBusiness employeeBusiness = new EmployeeBusiness();
		int i = employeeBusiness.addEmployee(employee);

		return i;

	}

	public ModelAndView listAllEmployeeHandler(HttpServletRequest req) {

		EmployeeBusiness employeeBusiness = new EmployeeBusiness();
		List<Employee> employeeDetails = employeeBusiness.getAllEmployee();
		System.out.println("hlo");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeeList.jsp");
		mv.addObject("employeeDetails", employeeDetails);

		return mv;

	}

	public void searchEmployee(HttpServletRequest req) {
		String empCodes = null;
		empCodes = req.getParameter("sempCode");

		int empCode = 0;
		System.out.println(empCodes);
		if (!empCodes.equals("")) {
			System.out.println(empCodes.equals(""));

			empCode = Integer.parseInt(empCodes);
		}
		String empCity = req.getParameter("sempCity");

		String empState = req.getParameter("sempState");

		String localDate = req.getParameter("sfromDate");

		LocalDate joiningDateFrom = null;
		if (!localDate.equals("")) {
			joiningDateFrom = LocalDate.parse(localDate);
		}
		String joiningDate1 = req.getParameter("stoDate");
		LocalDate joiningDateTo = null;
		if (!joiningDate1.equals("")) {
			joiningDateTo = LocalDate.parse(joiningDate1);
		}
		System.out.println(joiningDateFrom + " date " + joiningDateTo);
		Employee employee = new Employee(empCode, empCity, empState, joiningDateFrom, joiningDateTo);
		EmployeeBusiness employeeBusiness = new EmployeeBusiness();
		List<Employee> emplist = employeeBusiness.searchEmployee(employee);
		System.out.println(emplist.get(0).getEmpEmail() + "helo");
		HttpSession session = req.getSession();
		session.setAttribute("employeeDetails", emplist);

	}

	public List<Employee> searchEmployeeOne(HttpServletRequest req) {
		int employeeCode = Integer.parseInt(req.getParameter("employeeCode"));
		Employee employee = new Employee();
		employee.setEmpCode(employeeCode);
		EmployeeBusiness employeeBusiness = new EmployeeBusiness();
		List<Employee> emplist = employeeBusiness.searchOne(employee);
		return emplist;
	}

}
