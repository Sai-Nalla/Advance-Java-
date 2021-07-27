
<jsp:useBean id="st" class="com.nt.beans.StudentBean" scope="session"/>
<br>
sno::<jsp:getProperty name="st" property="sno"/><br>
name::<jsp:getProperty name="st" property="name"/><br>
Addrs::<jsp:getProperty name="st" property="addrs"/><br>
Avg::<jsp:getProperty name="st" property="avg"/><br>