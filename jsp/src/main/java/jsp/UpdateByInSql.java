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

@WebServlet("/updateById")
public class UpdateByInSql extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		String mobileBrand = req.getParameter("mobileBrand");
		String mobileModel = req.getParameter("mobileModel");
		int year = Integer.parseInt(req.getParameter("year"));
		int mobilePrice = Integer.parseInt(req.getParameter("mobilePrice"));
		Connection con = null;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_material", "root", "root@123");
			PreparedStatement pstm = con.prepareStatement(
					"UPDATE mobiledb SET MOBILEBRAND = ?, MOBILEMODEL = ?, YEAR = ?, MOBILEPRICE = ? WHERE MOBILEID = ? ;");
			pstm.setString(1, mobileBrand);
			pstm.setString(2, mobileModel);
			pstm.setInt(3, year);
			pstm.setInt(4, mobilePrice);
			pstm.setInt(5, mobileId);
			pstm.executeUpdate();
			resp.sendRedirect("omg");
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}
