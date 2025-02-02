package calculator.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ModNumberServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		double str1 = Double.parseDouble(req.getParameter("num1"));
		double str2 = Double.parseDouble(req.getParameter("num2"));
		PrintWriter p = res.getWriter();
		p.println(str1 % str2);
	}
}
