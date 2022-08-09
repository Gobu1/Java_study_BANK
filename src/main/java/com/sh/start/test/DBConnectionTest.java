package com.sh.start.test;

import java.sql.Connection;

import com.sh.start.utill.DBConnector;

public class DBConnectionTest {

	public static void main(String[] args) {
		try {
			Connection con = DBConnector.getConnection();
			System.out.println(con != null);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
