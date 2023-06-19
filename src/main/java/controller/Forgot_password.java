package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Doctor;
import dto.Staff;

@WebServlet("/forgotpassword")
public class Forgot_password extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("number"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		String password = req.getParameter("password");

		AccessDB adb = new AccessDB();
		Doctor doctor = adb.fetchDoctor(id);
		Staff staff = adb.fetchStaff(id);

		if (doctor == null && staff == null)
		{
			resp.getWriter().print("<h1 style='color:red'>Invalid Id</h1>");
			req.getRequestDispatcher("forgot_password.html").include(req, resp);
		} 
		else 
		{
			if (doctor != null) 
			{
				if (doctor.getName().equals(name) && doctor.getMobile() == mobile && doctor.getDob().equals(dob))
				{
					doctor.setPassword(password);
					adb.update(doctor);
					resp.getWriter().print("<h1 style='color:green'>Password changed successful</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
				} 
				else 
				{
					resp.getWriter().print("<h1 style='color:red'>Invalid Details</h1>");
					req.getRequestDispatcher("forgot_password.html").include(req, resp);
				}
			} 
			else 
			{
				if (staff != null) 
				{
					if (staff.getName().equals(name) && staff.getMobile() == mobile && staff.getDob().equals(dob))
					{
						staff.setPassword(password);
						adb.update(staff);
						resp.getWriter().print("<h1 style='color:green'>Password changed successful</h1>");
						req.getRequestDispatcher("login.html").include(req, resp);
					} 
					else 
					{
						resp.getWriter().print("<h1 style='color:red'>Invalid Details</h1>");
						req.getRequestDispatcher("forgot_password.html").include(req, resp);
					}
				}
			}
		}

	}
}
