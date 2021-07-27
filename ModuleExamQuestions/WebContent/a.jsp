<%@ page  import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
int a[]={1,2,3,4,5};
List<Integer> list= new ArrayList<>();
for(int i:a)
list.add(i);
int count=0;
	%>	
	<form action="nexturl" method="post">
<%	if(request.getAttribute("count")!=null){
 count=(Integer)request.getAttribute("count");
 System.out.println(count);
 }
 %>
 <%=list.get(count) %>
	<input type="hidden" name='hidden' value="<%=count%>">
	<input type="submit"  name="s" value="next" ><br>
	<input type="submit" name="s" value="previous"><br>
	<input type="submit" name="s" value="submit" >
	</form>
	