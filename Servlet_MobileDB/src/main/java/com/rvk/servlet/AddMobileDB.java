package com.rvk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddMobileDB extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		String mobileBrand = req.getParameter("mobileBrand");
		String mobileModel = req.getParameter("mobileModel");
		int year = Integer.parseInt(req.getParameter("year"));
		int mobilePrice = Integer.parseInt(req.getParameter("mobilePrice"));
		PrintWriter pw = res.getWriter();
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_material", "root", "root@123");
			PreparedStatement pstm = con.prepareStatement("INSERT INTO mobiledb VALUE (?,?,?,?,?);");
			pstm.setInt(1, mobileId);
			pstm.setString(2, mobileBrand);
			pstm.setString(3, mobileModel);
			pstm.setInt(4, year);
			pstm.setInt(5, mobilePrice);
			int update = pstm.executeUpdate();
			if (update > 0) {
				pw.print("It SucessFully Inserted !");
				pw.println("<h1><a href='Display-Mobile'>Display Result</a></h1>");
				pw.println("<h3><a href='index.html'>Home</a></h3>");
			} else {
				pw.print("It is Not Inserted ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
