<%@page language="java" session="true"%>
<html>
<head>
Welcome back!&nbsp; <%=request.getAttribute("returningUsername")%>
make a get form with options and check grade that goes to returning options servlet
<body>
Your current grade is <%=request.getSession().getAttribute("gradeAverage")%>



</body>
</head>
</html>