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

/**
 * Servlet implementation class IncludeResponseServlet
 */
@WebServlet("/includeurl")
public class IncludeResponseServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
				PrintWriter pw=res.getWriter();
				res.setContentType("text/html");
				final String QUERY="select * from emp where empno=?";
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				RequestDispatcher rd,rd1,rd2;
				ServletContext sc=getServletContext();
				//read form data
				int no=Integer.parseInt(req.getParameter("empno"));
				//include header servlet
				 rd= sc.getRequestDispatcher("/headurl");
				rd.include(req, res);
				try {
					//load driver class
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//get connection obj
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
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
				//include footer element
				 rd2=sc.getRequestDispatcher("/footer.html");
				 rd2.include(req,res);
				 //close the stream
				 pw.close();
		
				}	
				
				 catch(Exception e) {
						e.printStackTrace();
						 rd1=sc.getRequestDispatcher("/errorurl");
						rd1.forward(req, res);
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
				
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}

