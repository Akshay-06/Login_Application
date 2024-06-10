<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.LoginApp.dao.UserDaoJdbc, com.LoginApp.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>
	<%!UserDaoJdbc userDao = new UserDaoJdbc();%>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
		return;
	}

	String username = (String) session.getAttribute("username");
	User user = userDao.getUser(username);
	String message = session.getAttribute("updateProfileCheck") == null ? ""
			: (String) session.getAttribute("updateProfileCheck");
	session.removeAttribute("updateProfileCheck"); // Remove session attribute after displaying
	%>

	<h1>
		Welcome
		<%=username%></h1>

	<!-- Logout form -->
	<form action="logout" method="post" style="text-align: right">
		<input type="submit" value="Logout">
	</form>

	<!-- Update profile form -->
	<form action="updateProfile" method="post">
		User ID:
		<%=user.getId()%><br> Username: <input type="text"
			value="<%=user.getUsername()%>" name="username"><br>
		Email: <input type="email" value="<%=user.getEmail()%>" name="email"
			readonly><br> Password: <input type="password"
			value="<%=user.getPassword()%>" name="password"><br> <input
			type="submit" value="Update">
	</form>

	<!-- Display update message -->
	<div style="color: green;">
		<%=message%>
	</div>

</body>
</html>
