package com.LoginApp.controller;

import java.io.IOException;

import com.LoginApp.dao.UserDaoJdbc;
import com.LoginApp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {

	private UserDaoJdbc userDao = new UserDaoJdbc();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));

		if (userDao.createUser(user)) {
			response.sendRedirect("login.jsp");
		}
	}

}
