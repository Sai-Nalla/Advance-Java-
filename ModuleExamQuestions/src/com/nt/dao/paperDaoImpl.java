package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.bean.Questionbean;

public class paperDaoImpl {
	private static final  String QUERY="SELECT * FROM QUESTIONS";
	public List<Questionbean> getQuestionPaper(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Questionbean bean=null;
		List<Questionbean> listbean=new ArrayList<Questionbean>();
		try {
			//load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//get connection obj
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//get prepared ststement obj
		 ps=con.prepareStatement(QUERY);
		 if(ps!=null) 
			//set query param values
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 bean=new Questionbean();
				 bean.setQuestion_id(rs.getInt(1));
				 bean.setQuestion_name(rs.getString(2));
				 bean.setOption1(rs.getString(3));
				 bean.setOption2(rs.getString(4));
				 bean.setOption3(rs.getString(5));
				 bean.setOption4(rs.getString(6));	 	
				 listbean.add(bean);
			 }
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
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

		
return listbean;
}//method
	
	
		
	}//class
