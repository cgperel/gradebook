<html>
<head>
<style>
div.absolute{
    position: absolute;
    width: 50%;
    bottom: 10px;
    font-family: Arial;
    font-size: 10px;
    }
body{
    font-family: Verdana;
}
</style>
</head>
<body>
<img src="Aplus.jpg" alt="A+">
<body style="background-color:LightGray;">
<h2 style="color:purple;"> Welcome to your grade book!</h2>
<form action = "/calculator" method = "GET">
Hello world!<br/>
<br/>
Username/Email: <input type="text" name="username" />
<br/><br/>
How many test grades would you like to calculate? <input type="number" name="numberOfTestGrades"/>

<!--Password: <input type="text" name="password" />
<br/><br/>-->
Press register to Login.
<br/><br/>
<input type = "submit" value = "Register" />

</form>
<br/><br/>

<form action = "/calculator" method = "GET" >
Are you a returning user? Enter username to check your grade. <input type="text" name="returningUsername" />
<br/><br/>
Press check my grade.
<br/><br/>
<input type = "submit" value ="Check my grade"/>
</form>
<div class="absolute">
Current date and time: <%=(new java.util.Date()).toLocaleString()%>
<br/><br/>
<%
out.println("Your IP address is "+ request.getRemoteAddr());
%><br/>
</div>
</body>
</html>
