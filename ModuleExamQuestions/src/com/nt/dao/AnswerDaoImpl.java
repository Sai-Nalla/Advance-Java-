package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerDaoImpl {
	private static final String QUERY="select quest_no,crct_ans from questions";
	private static final String QUERY2="Insert Into results values(result_sid.nextval,?)";
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public boolean insertResults(int marks) {
		boolean flag=false;
		int rs=0;
		try {
		ps=con.prepareStatement(QUERY2);
		if(ps!=null) {
			ps.setInt(1, marks);
		 rs=ps.executeUpdate();
		}
		flag=(rs==1)?true:false;
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

		return flag;
		
	}
	public Map<Integer,String> getAnswers(){
	Map<Integer,String> ansMap=new HashMap<>();
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
		 while(rs.next()) 
			 ansMap.put(rs.getInt(1), rs.getString(2));
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return ansMap;

}
}
