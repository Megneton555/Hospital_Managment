package Admin_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Doctor;

@WebServlet("/ChangeDoctorStatus")
public class ChangeDoctorStatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		AccessDB adb = new AccessDB();
		Doctor doctor = adb.fetchDoctor(id);
		if (doctor.isStatus())
			doctor.setStatus(false);
		else
			doctor.setStatus(true);

		adb.update(doctor);

		resp.getWriter().print("<h1 style='color:green'>Status Updated</h1>");
		req.setAttribute("list", adb.fetchAllDoctor());
		req.getRequestDispatcher("Approve_Doctor.jsp").include(req, resp);
	}
}