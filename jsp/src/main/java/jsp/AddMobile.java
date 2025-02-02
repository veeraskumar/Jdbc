package jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class AddMobile extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		String mobileBrand = req.getParameter("mobileBrand");
		String mobileModel = req.getParameter("mobileModel");
		int year = Integer.parseInt(req.getParameter("year"));
		int mobilePrice = Integer.parseInt(req.getParameter("mobilePrice"));
		Connection con = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_material","root","root@123");
			PreparedStatement pstm = con.prepareStatement("INSERT INTO mobiledb VALUE (?,?, ? ,? ,?);");
			pstm.setInt(1, mobileId);
			pstm.setString(2, mobileBrand);
			pstm.setString(3, mobileModel);
			pstm.setInt(4, year);
			pstm.setInt(5, mobilePrice);
			pstm.executeUpdate();
			resp.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
