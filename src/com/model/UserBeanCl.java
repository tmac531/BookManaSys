package com.model;

import java.sql.*;
import java.util.*;

public class UserBeanCl {

	private Statement sm = null;
	private ResultSet rs = null;
	private Connection ct = null;

	public void close() {

		try {

			if (rs != null)
				rs.close();
			if (sm != null)
				sm.close();

			if (ct != null)
				ct.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean checkUser(String username, String password) {

		boolean b = false;

		try {
			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			rs = sm.executeQuery("select sTuPassword from student where stuName='"
					+ username + "'");
			if (rs.next())
				if (rs.getString(1).equals(password))
					b = true;

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			this.close();

		}

		return b;

	}

}
