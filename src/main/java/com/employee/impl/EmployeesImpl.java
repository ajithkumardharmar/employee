package com.employee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.model.Employee;
import com.mobilesalesapp.logger.Logger;
import com.mobilesalesapp.util.ConnectionUtil;

public class EmployeesImpl {

	public int addEmployee(Employee employee) {
		Connection con = ConnectionUtil.connect();
		StringBuilder query = new StringBuilder();
		query.append("insert into employees1 (emp_code,emp_name,email,address1,address2,city,state ");
		query.append(",date_of_birth ,joining_date) VALUES(?,?,?,?,?,?,?,?,?)");
		int i = 0;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query.toString());
			pre.setInt(1, employee.getEmpCode());
			pre.setString(2, employee.getEmpName());
			pre.setString(3, employee.getEmpEmail());
			pre.setString(4, employee.getAddress1());
			pre.setString(5, employee.getAddress2());
			pre.setString(6, employee.getEmpCity());
			pre.setString(7, employee.getEmpState());
			pre.setDate(8, java.sql.Date.valueOf(employee.getDateOfBirth()));
			pre.setDate(9, java.sql.Date.valueOf(employee.getJoiningDate()));
			i = pre.executeUpdate();
		} catch (SQLException e) {
			Logger.printStackTrace(e);
		} finally {
			ConnectionUtil.close(null, pre, con);
		}
		return i;

	}

	public List<Employee> getAllEmployee() {

		Connection con = ConnectionUtil.connect();
		String query = "select emp_code,emp_name,email,city,state from employees1";

		List<Employee> employeeList = new ArrayList<>();
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = con.prepareStatement(query);
			rs = pre.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt("emp_code"), rs.getString("emp_name"), rs.getString("email"),
						rs.getString("city"), rs.getString("state"));
				employeeList.add(employee);

			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
		} finally {
			ConnectionUtil.close(rs, pre, con);
		}
		return employeeList;

	}

	public List<Employee> searchEmployee(Employee employee) {

		Connection con = ConnectionUtil.connect();

		StringBuilder query = new StringBuilder();
		List<Employee> employeeList = new ArrayList<>();
		query.append("select emp_code,emp_name,email,city,state from employees1 ");
		if (!employee.getEmpCity().equals("") || employee.getEmpCode() != 0 || !employee.getEmpState().equals("")
				|| (employee.getJoiningDatefrom() != null) || (employee.getJoiningDateTo() != null)) {

			query.append(" where ");
		}

		if (employee.getEmpCode() != 0) {
			query.append("emp_code= " + employee.getEmpCode());
		}
		if (!employee.getEmpCity().equals("")) {

			if (employee.getEmpCode() == 0) {
				query.append(" lower(city) like " + "'" + employee.getEmpCity().toLowerCase() + "%'");
			} else {
				query.append("and lower(city) like " + "'" + employee.getEmpCity().toLowerCase() + "%'");
			}

		}
		if (!employee.getEmpState().equals("")) {
			if (employee.getEmpCode() == 0 || employee.getEmpCity().equals("")) {
				query.append(" lower(state) like " + "'" + employee.getEmpState() + "%'");
			} else {
				query.append("and lower(state) like " + "'" + employee.getEmpState() + "%'");
			}

		}
		if (employee.getJoiningDatefrom() != null || employee.getJoiningDateTo() != null) {

			if (employee.getEmpCode() == 0 && (employee.getEmpCity().equals(""))
					&& (employee.getEmpState().equals(""))) {

				query.append(" to_char(joining_date,'yyyy-mm-dd') between  " + "'" + employee.getJoiningDatefrom()
						+ "' and '" + employee.getJoiningDateTo() + "'");
			} else {
				query.append("and to_char(joining_date,'yyyy-mm-dd') between  " + "'" + employee.getJoiningDatefrom()
						+ "' and '" + employee.getJoiningDateTo() + "'");
			}

			if (employee.getEmpCode() == 0 || (employee.getEmpCity().equals(""))
					|| (employee.getEmpState().equals(""))) {

				query.append(" to_char(joining_date,'yyyy-mm-dd') =  " + "'" + employee.getJoiningDatefrom() + "'");
			} else {
				query.append("and to_char(joining_date,'yyyy-mm-dd')=  " + "'" + employee.getJoiningDatefrom() + "'");
			}
		}

		try {
			PreparedStatement pre = con.prepareStatement(query.toString());
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Employee employees = new Employee(rs.getInt("emp_code"), rs.getString("emp_name"),
						rs.getString("email"), rs.getString("city"), rs.getString("state"));
				employeeList.add(employees);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(null, null, con);
		}
		System.out.println(employeeList);
		return employeeList;

	}

}
