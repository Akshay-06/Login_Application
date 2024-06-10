<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<%
String errorMessage="";
	if(request.getAttribute("errorMessage")!=null)
		errorMessage=(String)request.getAttribute("errorMessage");

	if (session.getAttribute("username") != null)
		response.sendRedirect("profile.jsp");
%>

	<h1>Login</h1>
	<form action="login" method="post">
		Username: <input type="text" name="username" required><br>
		Password: <input type="password" name="password" required><br>

		<input type="submit" value="Login">
	</form>
	<div style="color: red;">
           <%=errorMessage %>
        </div>
	
</body>
</html>