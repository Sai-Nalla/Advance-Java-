package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/frwdurl")
public class ForwardReqServlet extends HttpServlet {
	
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final String QUERY="select * from emp where empno=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ServletContext sc=getServletContext();
		//get printwriter
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int no=Integer.parseInt(req.getParameter("empno"));
		String driver=sc.getInitParameter("driverClass");
		String url=sc.getInitParameter("url");
		String user=sc.getInitParameter("user");
		String pwd=sc.getInitParameter("pwd");
		try {
			//load driver class
			Class.forName(driver);
			//get connection obj
			con=DriverManager.getConnection(url,user,pwd);
			//get prepared ststement obj
		 ps=con.prepareStatement(QUERY);
		 if(ps!=null) {
			 ps.setInt(1, no);
		 }
		 rs=ps.executeQuery();
		 if(rs.next()) {
			 pw.println("<h1 style='color:red text-align:center'>Employee Details are</h1>");
			 pw.println("<br><b> Emp number:: "+rs.getInt(1)+"</b>");
			  pw.println("<br><b> Emp name:: "+rs.getString(2)+"</b>");
			  pw.println("<br><b> Emp Desg:: "+rs.getString(3)+"</b>");
			  pw.println("<br><b> Emp Salary:: "+rs.getFloat(4)+"</b>");
		 }
		 else {
			 pw.println("<h1 style='color:red text-align:center'>Record not Found</h1>");
		 }	
		//close the Stream
			pw.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=sc.getRequestDispatcher("/errorurl");
			rd.forward(req, res);
		}
		finally {
			try {
			if(rs!=null) {
				rs.close();
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null) {
					ps.close();
				}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			try {
				if(con!=null) {
					con.close();
				}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}//finally
		}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
