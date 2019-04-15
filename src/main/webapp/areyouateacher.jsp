<html>
<%
    String username = request.getParameter("username");
    Cookie theCookie = new Cookie("myApp.username", username);
    theCookie.setMaxAge(60*60*24*365);
    response.addCookie(theCookie);
    %>
<body>
You are logged in as ${param.username}
<br/><br/>

<a href="index.jsp">Return to homepage.</a>
<form action = "/authenticate" method = "POST">
Are you a teacher?
<input type = "checkbox" name="areYouATeacher" value="Yes"/> Yes
<input type = "checkbox" name="areYouATeacher" value="No"/> No
</form>
</body>
</html>

<% --set method as post implement doPost in servlet and 2 parameter --%>