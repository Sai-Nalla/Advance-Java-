<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

<h1 style="color:bule"> Add Questions</h1>
<form action="addurl" method="post">
<table  border="1",align="right">
<tr>Question</tr><br>

<tr><textarea rows="2" cols="50" name="question"></textarea></tr><br>

<tr>Option1</tr><br>
<tr><input type="text" name="opt1"></tr><br>
<tr>Option2</tr><br>
<tr><input type="text" name="opt2"></tr><br>
<tr>Option3</tr><br>
<tr><input type="text" name="opt3"></tr><br>
<tr>Option4</tr><br>
<tr><input type="text" name="opt4"></tr><br>
<tr>CrctAns</tr><br>
<tr><input type="text" name="crctans"></tr><br>
<tr><input type="submit" value="submit"></tr>
</table>
</form>


</body>
</html>