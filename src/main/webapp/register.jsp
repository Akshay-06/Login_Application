<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<%
	if (session.getAttribute("username") != null)
		response.sendRedirect("profile.jsp");
	%>

	<h1>Register</h1>
	<form action="register" method="post">
		Username: <input type="text" name="username" required><br>
		Email: <input type="email" name="email" required><br>
		Password: <input type="password" name="password" required><br>
		<input type="submit" value="Register">
	</form>
</body>
</html>