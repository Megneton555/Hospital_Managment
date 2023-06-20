package Doctor_controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Appointment;

@WebServlet("/checkappointment")
public class CheckAppointment extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		AccessDB dao = new AccessDB();

		Appointment appointment = dao.fetchAppointment(id);
		appointment.setTime(LocalDateTime.now());
		dao.updateAppointment(appointment);

		resp.getWriter().print("<h1 style='color:green; position:absolute; bottom:33.5rem;'>Successfully Updated</h1>");
		req.getRequestDispatcher("Doctor_Home.html").include(req, resp);
	}
}