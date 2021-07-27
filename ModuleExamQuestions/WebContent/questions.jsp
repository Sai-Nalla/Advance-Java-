<%@ page import="java.util.*,com.nt.bean.Questionbean" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%
int current=0;
List<Questionbean> list=null;
Questionbean bean1=null;
list=(List<Questionbean>)session.getAttribute("question1");%>
<form action="nexturl" method="POST">

<%
if(request.getAttribute("current")!=null){
	 current=(Integer)request.getAttribute("current");
}
bean1=list.get(current);
session.setAttribute("question_id", bean1.getQuestion_id());
	%>
 <h1><%=bean1.getQuestion_name() %></h1><br>
	<input type="radio" name="<%=bean1.getQuestion_id()%>" value="A"><%=bean1.getOption1()%><br>
	<input type="radio" name="<%=bean1.getQuestion_id()%>" value="B"><%=bean1.getOption2() %><br>
	<input type="radio" name="<%= bean1.getQuestion_id()%>" value="C"><%=bean1.getOption3() %><br>
	<input type="radio" name="<%= bean1.getQuestion_id()%>" value="D"><%=bean1.getOption4() %>	<br>	

<input type="hidden" name="hidden" value="<%=current%>" >
<% if(current!=list.size()-1) { %>
<input type="submit" name="target" value="next">
<%} %>
<% if(current!=0) {%>
<input type="submit" name="target" value="previous">
<%} %>
<input type="submit" name="target" value="Submit">
</form>
	



