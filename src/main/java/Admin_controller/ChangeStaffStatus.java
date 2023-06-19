package Admin_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Staff;

@WebServlet("/ChangeStaffStatus")
public class ChangeStaffStatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		AccessDB adb = new AccessDB();
		Staff staff = adb.fetchStaff(id);
		if (staff.isStatus())
			staff.setStatus(false);
		else
			staff.setStatus(true);

		adb.update(staff);

		resp.getWriter().print("<h1 style='color:green'>Status Updated</h1>");
		req.setAttribute("list", adb.fetchAllStaff());
        req.getRequestDispatcher("Approve_Staff.jsp").include(req, resp);
	}
}