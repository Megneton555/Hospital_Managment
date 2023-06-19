package Doctor_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Doctor;

@WebServlet("/changedoctoravailable")
public class ChangeDoctorAvailability extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Doctor doctor =(Doctor) req.getSession().getAttribute("doctor");
		
		AccessDB dao=new AccessDB();
		
		if(doctor==null)
		{
			resp.getWriter().print("<h1 style='color:red'>Session Expired</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		else {
			if(doctor.isAvailable())
			{
				doctor.setAvailable(false);
				dao.update(doctor);
				req.getSession().setAttribute("doctor", doctor);
				resp.getWriter().print("<h1 style='color:red; position:absolute; bottom:33.5rem;'>Changed to Not Available</h1>");
				req.getRequestDispatcher("Doctor_Home.html").include(req, resp);
			}
			else {
				doctor.setAvailable(true);
				dao.update(doctor);
				req.getSession().setAttribute("doctor", doctor);
				resp.getWriter().print("<h1 style='color:green; position:absolute; bottom:33.5rem;'>Changed to Available</h1>");
				req.getRequestDispatcher("Doctor_Home.html").include(req, resp);
			}
		}
	}
}