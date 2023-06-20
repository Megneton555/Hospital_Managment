package Staff_controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Patient;

@WebServlet("/updatepatient")
public class UpdatePatient extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();

		AccessDB adb = new AccessDB();

		Patient patient = adb.fetchPatient(id);

		patient.setAge(age);
		patient.setDob(dob);
		patient.setName(name);

		adb.updatePatient(patient);

		resp.getWriter().print("<h1 style='color:green; position:absolute; bottom:33.5rem'>Patient Data Updated Successfully</h1>");
		req.getRequestDispatcher("Staff_Home.html").include(req, resp);

	}
}