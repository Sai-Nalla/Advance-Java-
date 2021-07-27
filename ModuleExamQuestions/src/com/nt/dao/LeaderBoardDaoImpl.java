package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.bean.LeaderBoadrBean;

public class LeaderBoardDaoImpl {
	private static final String QUERY="SELECT S.SID,S.SNAME,R.MARKS FROM STUDENT S JOIN RESULTS R ON S.SID=R.SID ORDER BY R.MARKS DESC";
			   public List<LeaderBoadrBean > getLeaderBoard(){
				   Connection con=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
					LeaderBoadrBean bean=null;
					List<LeaderBoadrBean> listbean=new ArrayList<LeaderBoadrBean>();
					try {
						//load driver class
						Class.forName("oracle.jdbc.driver.OracleDriver");
						//get connection obj
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						//get prepared ststement obj
					 ps=con.prepareStatement(QUERY);
					 if(ps!=null) {
						 rs=ps.executeQuery();
					 }
						 while(rs.next()) {
							 bean=new LeaderBoadrBean();
							 bean.setSid(rs.getInt(1));
							 bean.setSname(rs.getString(2));
							 bean.setMarks(rs.getInt(3));
							 listbean.add(bean);
						 }
							 
					 }//try
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

			   }

}
