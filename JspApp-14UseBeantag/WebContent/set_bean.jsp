

<jsp:useBean id="st" class="com.nt.beans.StudentBean" scope="session"/> 

<!--  if our bean  property name and req param are matching atribute is  -->
<jsp:setProperty name="st" property="*"/>

<!--  reading data from form and seetiing to bean obj -->
<%--<jsp:setProperty name="st" property="sno" param="sno"/> 
<jsp:setProperty name="st" property="name" param="sname"/>
<jsp:setProperty name="st" property="addrs" param="adrs"/>
<jsp:setProperty name="st" property="avg" param="avg"/>--%>

<%-- Set bean proporties  --%>
 <jsp:setProperty name="st" property="sno" value="1001"/>
<jsp:setProperty name="st" property="name" value="sai"/>
<jsp:setProperty name="st" property="addrs" value="hyd"/>
<jsp:setProperty name="st" property="avg" value="52.0"/>

<br><b>bean property values are set</b><br>
