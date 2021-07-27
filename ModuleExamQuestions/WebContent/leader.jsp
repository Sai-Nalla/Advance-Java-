<%@ page import="java.util.*,com.nt.bean.LeaderBoadrBean" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%  List<LeaderBoadrBean> list=(List<LeaderBoadrBean>) request.getAttribute("leader"); %>
               

<table border="1" bgcolor="cyan" align="center">
<tr>
<td>SID</td><td>Sname</td><td>Marks</td>
</tr>
<% for(LeaderBoadrBean bean:list){ %>
<tr>
<td> <%=bean.getSid() %></td>
<td> <%=bean.getSname() %></td>
<td> <%=bean.getMarks() %></td>
</tr>
<%} %>

</table>

