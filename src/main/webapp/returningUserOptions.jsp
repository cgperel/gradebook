<%@page language="java" session="true"%>
<%@ page import="database.Student"%>
<html>
<head>
Welcome back!&nbsp; <%=request.getAttribute("returningUsername")%>

<%

Student[] students=(Student[])request.getAttribute("students");


%>

Your current grade is <%=request.getAttribute("average")%>.

<form method ="GET" action ="returningUserResults.jsp">
<input type ="submit" value="Get my results."/>
</form>
<body>
</br></br>
What is your name?
What would you like to do?
1. Update Grade
<form method="POST" action="/returningUserOptions">
New test grade: <input type="number" name="testGrade"/>
<button type="submit"> Update my grade</button>
</form>
</br></br>
2. Pull multiple grades for one name
<form method="GET" action="/returningUserOptions">
<br/><br/>
What class would you like a list of grades for?
<select name ="classname">
<option value="History">History</option>
<option value="Math">Math</option>
<option value="English">English</option>
<option value="Science">Science</option>
</select>
<br/><br/>



</body>
</head>
</html>