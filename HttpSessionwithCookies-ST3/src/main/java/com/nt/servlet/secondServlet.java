package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/surl")
public class secondServlet extends HttpServlet {
	
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,ms=null,f2t1=null,f2t2=null;
		HttpSession ses=null;
		//getPrintWriter
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		f2t1=req.getParameter("f2t1");
		f2t2=req.getParameter("f2t2");
		//get session obj
		ses=req.getSession(false);
		//read form 1 data
		if(ses!=null) {
		name=(String)ses.getAttribute("name");
		addrs=(String)ses.getAttribute("addrs");
		ms=(String)ses.getAttribute("ms");
		}
		//print form data
		pw.println("<b style='text-align:center;color:red'>Form 1 data :"+name+" "+addrs+" "+ms+"</b>");
		pw.println("<br><br><b style='text-align:center;color:red'>Form 2 data :"+f2t1+" "+f2t2+"</b>");
		pw.println("<br><br><b style='color:red'>"+ses.getId()+"</b>");
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
