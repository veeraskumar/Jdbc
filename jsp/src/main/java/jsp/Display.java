package jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/omg")
public class Display extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con = null;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_material", "root", "root@123");
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM mobiledb");
			ResultSet rs = pstm.executeQuery("SELECT * FROM mobiledb;");
			req.setAttribute("MobileList", rs);
			req.getRequestDispatcher("DisplayMobile.jsp").forward(req, resp);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
