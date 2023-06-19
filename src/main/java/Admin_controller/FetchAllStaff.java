package Admin_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Staff;

@WebServlet("/fetchallstaff")
public class FetchAllStaff extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin")!=null)
		{
		AccessDB adb=new AccessDB();
		List<Staff> list=adb.fetchAllStaff();
		if(list.isEmpty()){
			resp.getWriter().print("<h1 style='color:red'>No Staff Has SignedUp</h1>");
			req.getRequestDispatcher("Admin_Home.html").include(req, resp);
		}
		else{
			req.setAttribute("list", list);
			req.getRequestDispatcher("Approve_Staff.jsp").forward(req, resp);
		}
	   }
		else{
			resp.getWriter().print("<h1 style='color:red'>Session Expired, Login again</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}
