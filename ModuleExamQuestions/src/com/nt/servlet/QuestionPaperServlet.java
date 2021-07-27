package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.bean.Questionbean;
import com.nt.dao.paperDaoImpl;

/**
 * Servlet implementation class QuestionPaperServlet
 */
@WebServlet("/questionurl")
public class QuestionPaperServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=null;
		pw=res.getWriter();
		paperDaoImpl paper=null;
		List<Questionbean> listbean=null;
		paper=new paperDaoImpl();
		listbean=paper.getQuestionPaper();
		HttpSession ses=req.getSession();
		ses.setAttribute("question1", listbean);
		RequestDispatcher rd=req.getRequestDispatcher("/questions.jsp");
		rd.forward(req, res);
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
