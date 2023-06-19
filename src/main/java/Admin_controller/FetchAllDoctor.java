package Admin_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Doctor;

@WebServlet("/fetchalldoctor")
public class FetchAllDoctor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("admin") != null) {
			AccessDB adb = new AccessDB();
			List<Doctor> list = adb.fetchAllDoctor();
			if (list.isEmpty()) {
				resp.getWriter().print("<h1 style='color:red'>No Doctor Has SignedUp</h1>");
				req.getRequestDispatcher("Admin_Home.html").include(req, resp);
			} else {
				req.setAttribute("list", list);
				req.getRequestDispatcher("Approve_Doctor.jsp").forward(req, resp);
			}
		} else {
			resp.getWriter().print("<h1 style='color:red'>Session Expired, Login again</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}