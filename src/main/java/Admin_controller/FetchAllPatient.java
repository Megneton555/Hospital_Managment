package Admin_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Patient;

@WebServlet("/fetchallpatient")
public class FetchAllPatient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("admin") == null) {
			resp.getWriter().print("<h1 style='color:red'>Session Expired</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			AccessDB adb = new AccessDB();
			List<Patient> list = adb.fetchAllPatient();
			if (list.isEmpty()) {
				resp.getWriter().print("<h1 style='color:red'>No Patient Data Found</h1>");
				req.getRequestDispatcher("Admin_Home.html").include(req, resp);
			} else {
				req.setAttribute("list", list);
				req.getRequestDispatcher("ViewPatientHistory.jsp").forward(req, resp);
			}
		}
	}

}
