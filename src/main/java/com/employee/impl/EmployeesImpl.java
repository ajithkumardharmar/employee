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
		int whereCount = 0;
		StringBuilder query = new StringBuilder();
		List<Employee> employeeList = new ArrayList<>();
		query.append("select emp_code,emp_name,email,city,state from employees1 ");
		if (!employee.getEmpCity().equals("") || employee.getEmpCode() != 0 || !employee.getEmpState().equals("")
				|| (employee.getJoiningDatefrom() != null) || (employee.getJoiningDateTo() != null)) {
			query.append(" where ");
		}

		if (employee.getEmpCode() != 0) {
			query.append("emp_code= " + employee.getEmpCode());
			whereCount++;
		}
		if (!employee.getEmpCity().equals("")) {
			System.out.println(whereCount + " counts");
			if (whereCount > 0) {
				query.append(" and ");
			}
			query.append(" lower(city) like " + "'" + employee.getEmpCity().toLowerCase() + "%'");
			whereCount++;
		}
		if (!employee.getEmpState().equals("")) {
			if (whereCount > 0) {
				query.append(" and ");

			}
			query.append(" lower(state) like " + "'" + employee.getEmpState() + "%'");
			whereCount++;
		}
		if (employee.getJoiningDatefrom() != null && employee.getJoiningDateTo() != null) {

			if (whereCount > 0) {

				query.append(" and ");

			}
			query.append(" to_char(joining_date,'yyyy-mm-dd') between  " + "'" + employee.getJoiningDatefrom()
					+ "' and '" + employee.getJoiningDateTo() + "'");
			whereCount++;

		}
		if (employee.getJoiningDatefrom() != null && employee.getJoiningDateTo() == null) {
			if (whereCount > 0) {

				query.append(" and ");

			}
			query.append(" to_char(joining_date,'yyyy-mm-dd')=  " + "'" + employee.getJoiningDatefrom() + "'");
			whereCount++;
		}
		try {
			System.out.println(query.toString());
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

	public List<Employee> getOneEmployee(Employee employee) {
		Connection con = ConnectionUtil.connect();
		List<Employee> employeeList = new ArrayList<>();
		StringBuilder query = new StringBuilder();
		query.append("select emp_code,emp_name,email,address1,address2,city,state,");
		query.append("date_of_birth ,joining_date from employees1 where emp_code=? ");
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query.toString());
			pre.setInt(1, employee.getEmpCode());

			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Employee employees = new Employee(rs.getInt("emp_code"), rs.getString("emp_name"),
						rs.getString("email"), rs.getString("address1"), rs.getString("address2"), rs.getString("city"),
						rs.getString("state"), rs.getDate("date_of_birth").toLocalDate(),
						rs.getDate("joining_date").toLocalDate());
				employeeList.add(employees);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(null, pre, con);

		}

		return employeeList;
	}

	public int updateEmployee(Employee employee) {
		Connection con = ConnectionUtil.connect();
		StringBuilder query = new StringBuilder();
		query.append("update employees1 set emp_name=?,address1=?,address2=?,city=?,state=?, ");
		query.append("date_of_birth=? ,joining_date=?  where emp_code=? ");
		int i = 0;
		System.out.println("updatw");
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query.toString());

			pre.setString(1, employee.getEmpName());
			pre.setString(2, employee.getEmpEmail());
			pre.setString(2, employee.getAddress1());
			pre.setString(3, employee.getAddress2());
			pre.setString(4, employee.getEmpCity());
			pre.setString(5, employee.getEmpState());
			pre.setDate(6, java.sql.Date.valueOf(employee.getDateOfBirth()));
			pre.setDate(7, java.sql.Date.valueOf(employee.getJoiningDate()));
			pre.setInt(8, employee.getEmpCode());
			i = pre.executeUpdate();
		} catch (SQLException e) {
			Logger.printStackTrace(e);
		} finally {
			ConnectionUtil.close(null, pre, con);
		}
		return i;

	}

	public String checkOneEmployee(Employee employee) {
		Connection con = ConnectionUtil.connect();
		List<Employee> employeeList = new ArrayList<>();
		StringBuilder query = new StringBuilder();
		query.append("select emp_code,emp_name,email,address1,address2,city,state,");
		query.append("date_of_birth ,joining_date from employees1 where emp_code=? ");
		PreparedStatement pre = null;
		String empName = null;
		try {
			pre = con.prepareStatement(query.toString());
			pre.setInt(1, employee.getEmpCode());

			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				empName = rs.getString("emp_name");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(null, pre, con);

		}

		return empName;
	}

}
