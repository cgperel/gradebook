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
<img src="https://live.staticflickr.com/6014/5963475453_bee44b6ed4_b.jpg" alt="A+" style="width: 200px;height:200px">
<body style="background-color:LightGray;">
<h2 style="color:purple;"> Welcome to your grade book!</h2>
<form action = "/calculator" method = "GET">
<br/>
Username/Email: <input type="text" name="username" />
<br/><br/>
Password: <input type="password" name="password" />
<br/><br/>
Press register to Login.
<br/><br/>
<input type = "submit" value = "Register" />

</form>
<br/><br/>
<form action = "returningUserOptions" method="GET">
Returning user? <input type="submit" value="Click here."/>
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
