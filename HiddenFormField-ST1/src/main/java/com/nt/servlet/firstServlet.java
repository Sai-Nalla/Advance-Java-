package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/furl")
public class firstServlet extends HttpServlet {
	
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,ms=null;
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
		if(ms.equalsIgnoreCase("married")){
			pw.println("<h1 style='color:red;text-align:center'>Dynamic Form 2</h1>");
			pw.println("<form action='surl' method='post'>");
			pw.println("<table border=' 1' align='center' bgcolor='cyan'>");
			pw.println("<tr><td>Spouse Name</td><td><input type=''text' name='f2t1'></td></tr>");
			pw.println("<tr><td>No of Childrens</td><td><input type=''text' name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='1'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("<tr><td><input type='hidden' name='h1' value="+name+"></td><td><input type='hidden' name='h2' value="+addrs+"></td><td><input type='hidden' name='h3' value="+ms+"></td></tr>");
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
			pw.println("<tr><td><input type='hidden' name='h1' value="+name+"></td><td><input type='hidden' name='h2' value="+addrs+"></td><td><input type='hidden' name='h3' value="+ms+"></td></tr>");
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
