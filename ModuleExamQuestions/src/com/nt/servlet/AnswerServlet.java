package com.nt.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dao.AnswerDaoImpl;


@WebServlet("/answerurl")
public class AnswerServlet extends HttpServlet {
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Map<Integer,String > map=new HashMap<>();
			  int  count=0;
			HttpSession ses=request.getSession(true);
			AnswerDaoImpl ansdao=new AnswerDaoImpl();		
			map=ansdao.getAnswers();
				for(Map.Entry<Integer,String> entry:map.entrySet()) {
					
				System.out.println(entry.getValue()+" "+ses.getAttribute(String.valueOf(entry.getKey())));
					if(entry.getValue().trim().equals(ses.getAttribute(String.valueOf(entry.getKey())))) {
						System.out.println(count);
						count++;
					}
			}
		System.out.print(count);
		System.out.println(ansdao.insertResults(count));
				request.setAttribute("marks", count);
		
			
			RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
			}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
