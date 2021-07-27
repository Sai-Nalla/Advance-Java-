package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/nexturl")
public class nextServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int question_id=0;
		String ans=null;
		HttpSession ses=request.getSession(true);
		Integer count=(Integer.parseInt(request.getParameter("hidden")));
		System.out.println(count+"in serv");
		String button=request.getParameter("target");
		question_id=(int) ses.getAttribute("question_id");
		ans=request.getParameter(String.valueOf(question_id));
		ses.setAttribute(String.valueOf(question_id),ans);
		if(button.equals("next")) {
			request.setAttribute("current", count+1);	
		
		System.out.println(String.valueOf(question_id)+" "+ans);
		}
		else if(button.equals("previous")) {
				request.setAttribute("current", count-1);
				
		}
		else if(button.equals("Submit")) {
			response.sendRedirect("answerurl");
		}
		if(!button.equals("Submit")) {
		RequestDispatcher rd=request.getRequestDispatcher("/questions.jsp");
		rd.forward(request, response);

		/* if(!button.equals("Submit")) {
		response.sendRedirect("questions.jsp");*/
		}
		}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
