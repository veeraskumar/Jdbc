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

@WebServlet("/Delete-Mob")
public class DeleteMob extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		Connection con = null;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_material", "root", "root@123");
			PreparedStatement pstm = con.prepareStatement("DELETE FROM mobiledb WHERE MOBILEID = ? ");
			pstm.setInt(1, mobileId);
			pstm.executeUpdate();
			resp.sendRedirect("omg");
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}