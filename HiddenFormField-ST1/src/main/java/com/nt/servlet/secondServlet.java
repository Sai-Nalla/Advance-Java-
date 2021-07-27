package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/surl")
public class secondServlet extends HttpServlet {
	
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,ms=null,f2t1=null,f2t2=null;
		//getPrintWriter
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("h1");
		addrs=req.getParameter("h2");
		ms=req.getParameter("h3");
		f2t1=req.getParameter("f2t1");
		f2t2=req.getParameter("f2t2");
		//print form data
		pw.println("<b style='text-align:center;color:red'>Form 1 data :"+name+" "+addrs+" "+ms+"</b>");
		pw.println("<br><br><b style='text-align:center;color:red'>Form 2 data :"+f2t1+" "+f2t2+"</b>");
		//add hyperlink
		pw.println("<br><br><a href='details.html'>Home</a>");
		//close the stream 
				pw.close();
		
		}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
