<%@page language="java" session="true"%>
<html>
<head>
Welcome back!&nbsp; <%=request.getAttribute("returningUsername")%>

<body>


Your current grade is <%=request.getAttribute("average")%>
</br></br>

make a get form with options and check grade that goes to returning options servlet

</body>
</head>
</html>