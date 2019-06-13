<%@page language="java" session="true" %>
<html>
<body>
Congratulations, <%=request.getSession().getAttribute("username")%>
<br/><br/>
Your average is a&nbsp;<%=request.getAttribute("gradeAverage")%> and your letter grade is
<%=request.getAttribute("lettergrade")%>
and here is where I save my database.
</body>
</html>
