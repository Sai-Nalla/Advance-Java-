package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/furl")
public class firstServlet extends HttpServlet {
	
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,ms=null;
		HttpSession ses=null;
		//getPrintWriter
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("name");
		addrs=req.getParameter("addrs");
		ms=req.getParameter("ms");
		if(ms==null) {
			ms="single";
		}
		//create session obj
		ses=req.getSession();
		//add form values to seesion object using seesion attribute
		ses.setAttribute("name", name);
		ses.setAttribute("addrs",addrs);
		ses.setAttribute("ms", ms);
		pw.println("<br><b style='color:red'>"+ses.getId()+"</b>");
		if(ms.equalsIgnoreCase("married")){
			pw.println("<h1 style='color:red;text-align:center'>Dynamic Form 2</h1>");
			pw.println("<form action='surl' method='post'>");
			pw.println("<table border=' 1' align='center' bgcolor='cyan'>");
			pw.println("<tr><td>Spouse Name</td><td><input type=''text' name='f2t1'></td></tr>");
			pw.println("<tr><td>No of Childrens</td><td><input type=''text' name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='1'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Dynamic Form 2</h1>");
			pw.println("<form action='surl' method='post'>");
			pw.println("<table border=' 1' align='center' bgcolor='cyan'>");
			pw.println("<tr><td>When do u want to marry</td><td><input type=''text' name='f2t1'></td></tr>");
			pw.println("<tr><td>why do u want to marry</td><td><input type=''text' name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='1'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
		pw.println("</form>");
		}
		//close the stream 
		pw.close();
		}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
