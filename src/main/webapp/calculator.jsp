<%@page language="java" session="true" %>
<html>
<head>
<style>
body{
    color: blue;
    font-family: verdana;
    font-size:135%
}
</style>
</head>
Welcome&nbsp; <%=request.getSession().getAttribute("username")%>
<% Integer numberOfTestGrades = Integer.parseInt((String)request.getAttribute("numberOfTestGrades"));%>
<body>
<form action = "/calculator" method = "POST">
Enter test grades to calculate your current average and letter grade.
<br/><br/>
What class would you like to calculate your grade for?
<select name ="classname">
<option value="History">History</option>
<option value="Math">Math</option>
<option value="English">English</option>
<option value="Science">Science</option>
</select>
<br/><br/>
<%for (int i=0; i<numberOfTestGrades;i++){ %>
Test Grade: <input type="number" name="testGrade" />
 <br/><br/>

<%}%>

<input type="submit" value = "Calculate my grade" />
</form>
</body>
</html>
