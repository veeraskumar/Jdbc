package com.rvk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DispalyInHtml extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String s = req.getParameter("name").toUpperCase();
		
		PrintWriter p = res.getWriter();
		
		p.print("<h1>" + s + ", WelCome to Hello! </h1>");
	}

}
