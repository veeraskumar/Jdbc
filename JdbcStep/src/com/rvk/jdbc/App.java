package com.rvk.jdbc;

import java.sql.*;
import java.util.Scanner;

public class App {

	final static String url = "jdbc:mysql://localhost:3306/mydata";
	final static String user = "root";
	final static String password = "root@123";
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String sql = "INSERT INTO mobile VALUES('SAMSUNG', 'F15', 2023, 15999)";
//		String sql = "DELETE FROM  mydata.mobile WHERE NAME = 'MOTO'; ";
//		String sql = "SELECT * FROM MOBILE WHERE PRICES > (SELECT PRICES FROM MOBILE WHERE MODEL = 'T3');";

		prepareStatement();
	}

	static void statementJdbc(String sql) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, password); // Step 1 : to Connect to DriverManger
		Statement stm = con.createStatement(); // Step 2 : Create Statement
		int result = stm.executeUpdate(sql); // Step 3 : Execute Query
		System.out.println(result > 0 ? "Execution done !" : "Execution isn't Done.");
		con.close(); // Step 4 : Close the COnnnetion
	}

	static void fetchDataFromDB(String sql) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password); // Step 1 : to Connect to DriverManger
		Statement stm = con.createStatement(); // Step 2 : Create Statement
		ResultSet result = stm.executeQuery(sql); // Step 3 : Execute Query
		System.out.println("Brand\t\tModel\t\tyear\t\tPrice");
		while (result.next()) {
			System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t\t" + result.getInt(3) + "\t\t"
					+ result.getInt(4) + "\t\t");
		}
		con.close(); // Step 4 : Close the COnnnetion
	}

	static void prepareStatement() {
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection(url, user, password);
			PreparedStatement pstm = con.prepareStatement("INSERT INTO MOBILE VALUES(?,?,?,?)");
			System.out.println("Enter the Brand Name : ");
			pstm.setString(1, sc.next());
			System.out.println("Enter the Model : ");
			pstm.setString(2, sc.next());
			System.out.println("Enter the Released Year : ");
			pstm.setInt(3, sc.nextInt());
			System.out.println("Enter the Price of Phone ");
			pstm.setInt(4, sc.nextInt());
			int rs = pstm.executeUpdate();
			System.out.println(rs > 0 ? "done" : "undone");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}