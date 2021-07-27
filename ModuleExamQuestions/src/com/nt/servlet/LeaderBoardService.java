package com.nt.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bean.LeaderBoadrBean;
import com.nt.dao.LeaderBoardDaoImpl;


@WebServlet("/leaderurl")
public class LeaderBoardService extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
			LeaderBoardDaoImpl leaderDao=new LeaderBoardDaoImpl();
			List<LeaderBoadrBean> list;
			list=leaderDao.getLeaderBoard();
			req.setAttribute("leader", list);
			RequestDispatcher rd=req.getRequestDispatcher("/leader.jsp");
			rd.forward(req, res);
		}

		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
