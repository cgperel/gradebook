<%@page language="java" session="true" %>
<html>
<body>
Congratulations, <%=request.getSession().getAttribute("username")%>
<br/><br/>
Your average is a&nbsp;<%=request.getAttribute("gradeAverage")%> and your letter grade is
<%=request.getAttribute("lettergrade")%> in <%=request.getParameter("classname")%> class! Great job!
<br/><br/>
Here is where I save to my database.
</body>
</html>
