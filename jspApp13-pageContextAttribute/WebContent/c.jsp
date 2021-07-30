<br> from c.jsp<br>

attr1 ::<%= pageContext.getAttribute("attr1")%>
attr1 ::<%= pageContext.findAttribute("attr1")%>
<br>
attr2 ::<%=pageContext.getAttribute("attr2",pageContext.REQUEST_SCOPE)%>
attr2 ::<%=pageContext.findAttribute("attr2")%>
<br>
attr3 ::<%= pageContext.getAttribute("attr3",pageContext.SESSION_SCOPE)%>
attr3 ::<%= pageContext.findAttribute("attr3")%>
<br>
attr4 ::<%= pageContext.getAttribute("attr4",pageContext.APPLICATION_SCOPE)%>
attr4 ::<%= pageContext.findAttribute("attr4")%>
