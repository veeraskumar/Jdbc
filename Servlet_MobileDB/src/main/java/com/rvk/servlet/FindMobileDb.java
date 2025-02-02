package com.rvk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FindMobileDb extends GenericServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		PrintWriter pw = res.getWriter();
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_material", "root", "root@123");
			PreparedStatement pstm = con.prepareStatement("SELECT *  FROM MOBILEDB WHERE MOBILEID = ? ;");
			pstm.setInt(1, mobileId);
			ResultSet update = pstm.executeQuery();
			pw.print("<table border=\"1\" cellpadding=\"10\">");
			pw.print("<tr><td>Mobile Id</td><td>Mobile Brand</td><td>Mobile Model</td><td>Year</td><td>Mobile Price</td><td>");
			while (update.next()) {
				pw.print("<tr><td>" + update.getInt("mobileId") + "</td><td>" + update.getString("mobileBrand")
						+ "</td><td>" + update.getString("mobileModel") + "</td><td>" + update.getInt("year")
						+ "</td><td>" + update.getInt("mobilePrice") + "</td></tr>");
			}
			pw.print("</table>");
			pw.println("<h1><a href='Display-Mobile'>Display Result</a></h1>");
			pw.println("<h3><a href='index.html'>Home</a></h3>");
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
