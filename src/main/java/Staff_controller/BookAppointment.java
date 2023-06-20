package Staff_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDB;
import dto.Appointment;
import dto.Doctor;
import dto.Patient;

@WebServlet("/bookappointment")
public class BookAppointment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		int did=Integer.parseInt(req.getParameter("doctor"));
		String problem=req.getParameter("problem");
		
		AccessDB adb=new AccessDB();
		Doctor doctor=adb.fetchDoctor(did);
		Patient patient=adb.fetchPatient(pid);
		
		Appointment appointment=new Appointment();
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointment.setProblem(problem);
		
		List<Appointment> list1=patient.getAppointments();
		if(list1==null)
		{
			list1=new ArrayList<>();
		}
		list1.add(appointment);
		patient.setAppointments(list1);
		
		List<Appointment> list2=doctor.getAppointment();
		if(list2==null)
		{
			list2=new ArrayList<>();
		}
		list2.add(appointment);
		doctor.setAppointment(list2);
		
		adb.saveAppointment(appointment);
		adb.update(doctor);
		adb.updatePatient(patient);
		
		resp.getWriter().print("<h1 style='color:green; position:absolute; bottom:33.5rem'>Appointment of "+patient.getName()+" is booked with Dr. "+doctor.getName()+" for "+problem+"</h1>");
		req.getRequestDispatcher("Staff_Home.html").include(req, resp);
	}
}