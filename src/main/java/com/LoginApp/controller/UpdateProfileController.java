package com.LoginApp.controller;

import java.io.IOException;

import com.LoginApp.dao.UserDaoJdbc;
import com.LoginApp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateProfileController
 */
public class UpdateProfileController extends HttpServlet {

	UserDaoJdbc userDao = new UserDaoJdbc();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create a new User object and set its fields from the request parameters
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		HttpSession session = request.getSession();

		// Update the user details in the database
		if (userDao.updateUser(user)) {
			// If update is successful, update the session attribute and set a success
			// message
			session.setAttribute("username", user.getUsername());
			session.setAttribute("updateProfileCheck", "Profile Details Updated Successfully");
		} else {
			// If update fails, set a failure message
			session.setAttribute("updateProfileCheck", "Details Not Updated");
		}

		// Redirect to profile.jsp
		response.sendRedirect("profile.jsp");
	}
}
