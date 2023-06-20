package Staff_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Patient;

@WebServlet("/stafffetchpatienthistory")
public class StaffViewPatientHistory extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("staff") == null) {
			resp.getWriter().print("<h1 style='color:red'>Session Expired</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			AccessDB adb = new AccessDB();
			List<Patient> list = adb.fetchAllPatient();
			if (list.isEmpty()) {
				resp.getWriter().print("<h1 style='color:red; position:absolute; bottom:33.5rem;'>No Patient Data Found</h1>");
				req.getRequestDispatcher("Staff_Home.html").include(req, resp);
			} else {
				req.setAttribute("list", list);
				req.getRequestDispatcher("ViewPatientHistory.jsp").forward(req, resp);
			}
		}
	}
}
