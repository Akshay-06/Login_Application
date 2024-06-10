package com.LoginApp.controller;

import java.io.IOException;

import com.LoginApp.dao.UserDaoJdbc;
import com.LoginApp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {

	private UserDaoJdbc userDao = new UserDaoJdbc();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		if (userDao.checkUserCredentials(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			response.sendRedirect("profile.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("errorMessage", "Invalid username or password");
			rd.forward(request, response);
		}

	}

}