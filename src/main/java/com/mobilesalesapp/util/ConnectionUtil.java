package com.mobilesalesapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobilesalesapp.logger.Logger;

public class ConnectionUtil {
	ConnectionUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static Connection connect() {
		Connection con = null;
		try {
			EncryptionAndDecryption encrypt = new EncryptionAndDecryption();
			Class.forName("oracle.jdbc.OracleDriver");
			String userName = "system";
			String password = encrypt.decryt();
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", userName, password);
		} catch (Exception e) {

			e.getMessage();
		}
		return con;

	}

	public static void close(ResultSet rs, PreparedStatement pre, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
		}
	}

}
