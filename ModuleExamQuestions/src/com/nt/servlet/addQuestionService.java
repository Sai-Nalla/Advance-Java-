package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bean.addQuestionsBean;
import com.nt.dao.addQuestionsDaoImpl;


@WebServlet("/addurl")
public class addQuestionService extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
			addQuestionsDaoImpl adddao=null;
			addQuestionsBean addbean=new addQuestionsBean();
			addbean.setQuestion(req.getParameter("question"));
			addbean.setOption1(req.getParameter("opt1"));
			addbean.setOption2(req.getParameter("opt2"));
			addbean.setOption3(req.getParameter("opt3"));
			addbean.setOption4(req.getParameter("opt4"));
			addbean.setCrctAns(req.getParameter("crctans").toUpperCase());
			
			//call dao method
			adddao=new addQuestionsDaoImpl();
			if(adddao.addQuestions(addbean)) 
				System.out.println("Insertion sucessful");
				else
					System.out.println("Insertion  not sucessful");
			RequestDispatcher rd=req.getRequestDispatcher("/addQuestion.jsp");
			rd.forward(req, res);		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
