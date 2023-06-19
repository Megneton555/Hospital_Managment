package Doctor_controller;

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
import dto.Doctor;

@WebServlet ("/doctor_signup")
public class Doctor_Signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccessDB adb = new AccessDB();

		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("number"));
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		String qualification=req.getParameter("Qualification");
		String specialization=req.getParameter("Specialization");
		String password = req.getParameter("password");

		if (adb.fetchStaff(mobile) == null && adb.fetchStaff(email) == null && adb.fetchDoctor(mobile) == null && adb.fetchDoctor(email) == null) {

			Doctor doctor =new Doctor();
			doctor.setName(name);
			doctor.setMobile(mobile);
			doctor.setEmail(email);
			doctor.setGender(gender);
			doctor.setDob(dob);
			doctor.setAge(age);
			doctor.setQualification(qualification);
			doctor.setSpecialization(specialization);
			doctor.setPassword(password);

			adb.saveDoctor(doctor);

			resp.getWriter().print("<h1 style='color:green'>Doctor Account is created Successfully, wait for Admin Approval</h1>");
			resp.getWriter().print("<h1 style='color:blue'>Your Doctor Id is: " +doctor.getId() + "</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		} else {
               resp.getWriter().print("<h1 style=color:red>Email or Mobile Number already exists </h1>");
               req.getRequestDispatcher("Doctor_Signup.html").include(req, resp);
		}
	}
}
