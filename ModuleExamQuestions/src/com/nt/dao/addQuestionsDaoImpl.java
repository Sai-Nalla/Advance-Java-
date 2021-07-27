package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.bean.addQuestionsBean;

public class addQuestionsDaoImpl {
private static final String QUERY="INSERT INTO QUESTIONS VALUES(quest_no_seq.nextval,?,?,?,?,?,?)";
public boolean  addQuestions(addQuestionsBean addbean) {
	Connection con=null;
	PreparedStatement ps=null;
	int rs=0;	
	boolean flag=false;

	try {
		//load driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//get connection obj
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		//get prepared ststement obj
	 ps=con.prepareStatement(QUERY);
	 if(ps!=null) {
		 ps.setString(1,addbean.getQuestion());
		 ps.setString(2,addbean.getOption1());
		 ps.setString(3,addbean.getOption2());
		 ps.setString(4,addbean.getOption3());
		 ps.setString(5,addbean.getOption4());
		ps.setString(6,addbean.getCrctAns());
		rs= ps.executeUpdate();
	 }
	 if(rs==1)
		 flag=true;
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
	

}
