package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/role_selection")
public class RoleSelection extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = req.getParameter("opt");
		if (role.equals("staff")) {
			req.getRequestDispatcher("Staff_Signup.html").forward(req, resp);
		} else {
			req.getRequestDispatcher("Doctor_Signup.html").forward(req, resp);
		}
	}
}
