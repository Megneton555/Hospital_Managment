package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Doctor;
import dto.Staff;
import dto.Patient;
import dto.Appointment;

public class AccessDB {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveStaff(Staff staff) {
		et.begin();
		em.persist(staff);
		et.commit();
	}

	public Object fetchStaff(long mobile) {
		List<Staff> list = em.createQuery("select x from Staff x where mobile=?1").setParameter(1, mobile).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Object fetchStaff(String email) {
		List<Staff> list = em.createQuery("select x from Staff x where email=?1").setParameter(1, email).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Staff fetchStaff(int id) {
		return em.find(Staff.class, id);
	}

	public void update(Staff staff) {
		et.begin();
		em.merge(staff);
		et.commit();
	}
	
	public List<Staff> fetchAllStaff(){
		 return em.createQuery("select x from Staff x").getResultList();
	}


	
	
	
	                                                              // Doctor
	
	
	public void saveDoctor(Doctor doctor) {
		et.begin();
		em.persist(doctor);
		et.commit();
	}

	public Object fetchDoctor(String email) {
		List<Doctor> list = em.createQuery("select x from Doctor x where email=?1").setParameter(1, email).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Object fetchDoctor(long mobile) {
		List<Doctor> list = em.createQuery("select x from Doctor x where mobile=?1").setParameter(1, mobile).getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Doctor fetchDoctor(int id) {
		return em.find(Doctor.class, id);
	}

	public void update(Doctor doctor) {
		et.begin();
		em.merge(doctor);
		et.commit();
	}
	
	public List<Doctor> fetchAllDoctor(){
		 return em.createQuery("select x from Doctor x").getResultList();
	}

	
	
	
	
	
	
	public void savePatient(Patient patient) {
		et.begin();
		em.persist(patient);
		et.commit();
	}

	public void updatePatient(Patient patient) {
		et.begin();
		em.merge(patient);
		et.commit();
	}
	
	public List<Patient> fetchAllPatient() {
		return em.createQuery("select x from Patient x").getResultList();
	}
	
	public Patient fetchPatient(long mobile) {
		List<Patient> list = em.createQuery("select x from Patient x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	public Patient fetchPatient(int id) {
		return em.find(Patient.class, id);
	}
	
	
	
	
	
	public List<Doctor> fetchAvailableDoctors()
	{
		return em.createQuery("select x from Doctor x where available=true").getResultList();
	}

	public void saveAppointment(Appointment appointment) {
		   et.begin();
		   em.persist(appointment);
		   et.commit();
		}
	
	
	public void updateAppointment(Appointment appointment) {
		et.begin();
		em.merge(appointment);
		et.commit();
	}
	
	
	public Appointment fetchAppointment(int id) {
		return em.find(Appointment.class, id);
	}

}
