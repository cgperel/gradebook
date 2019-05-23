<html>
<body>
<body style="background-color:LightGray;">
<h2 style="color:blue;"> Welcome to your grade book!</h2>
<form action = "/calculator" method = "GET">
Hello world!<br/>
<br/>
Username/Email: <input type="text" name="username" />
<br/><br/>
How many test grades would you like to calculate? <input type="number" name="numberOfTestGrades"/>
<br/><br/>
<!--Password: <input type="text" name="password" />
<br/><br/>-->
Press Start to Login.
<br/><br/>
<input type = "submit" value = "Start" />
</form>

Current date and time: <%=(new java.util.Date()).toLocaleString()%>
<br/><br/>
<%
out.println("Your IP address is "+ request.getRemoteAddr());
%><br/>

</body>
</html>
