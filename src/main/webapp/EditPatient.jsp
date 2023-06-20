<%@page import="dto.Patient"%>
<%@page import="dao.AccessDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id")); 
AccessDB adb=new AccessDB();
Patient patient=adb.fetchPatient(id);
if(patient==null)
{
	response.getWriter().print("<h1 style='color:red'>Enter Valid id</h1>");
	request.getRequestDispatcher("EnterPatientId.html").include(request, response);
}
else{
%>

<form action="updatepatient" method="post">
Id:<input type="number" name="id" value="<%=patient.getId()%>" readonly="readonly">
<br>
Name:<input type="text" name="name" value="<%=patient.getName()%>">
<br>
Mobile:<input type="number" name="mobile" value="<%=patient.getMobile()%>" readonly="readonly">
<br>
Date of Birth:<input type="date" name="dob" value="<%=patient.getDob()%>">
<br>
<button>Update</button><button type="reset">Cancel</button>
</form>
<br>
<a href="EnterPatientId.html"><button>Back</button></a>
<%} %>
</body>
</html>