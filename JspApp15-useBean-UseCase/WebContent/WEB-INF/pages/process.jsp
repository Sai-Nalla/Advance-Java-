

<!-- Create or locate bean obj  and set property vlue-->
<jsp:useBean id="dt" class="com.nt.beans.EmployeeBean" scope="request"/>
<jsp:setProperty name="dt" property="*"/>

<!-- Call Service Method -->
<jsp:useBean id="emp"
             class="com.nt.service.EmployeeMgmtServiceImpl" 
             scope="session"
             type="com.nt.service.EmployeeMgmtService"/>
     
     <%
     emp.processResult(dt);
     
     %>
<br><b>EmployeDetails Are::::</b>
EmpID::<jsp:getProperty name="dt" property="empsal"/>
EmpName::<jsp:getProperty name="dt" property="empname"/>