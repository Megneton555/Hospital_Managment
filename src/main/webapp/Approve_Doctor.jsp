<%@page import="java.util.List"%>
<%@page import="dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Data</title>
</head>
<body>
        
   
    <table border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Age</th>
		    <th>Status</th>
		    <th>ChangeStatus</th>
		</tr>
         
          <% List<Doctor> list=(List<Doctor>) request.getAttribute("list");
	         for(Doctor doctor:list){
	      %>
	      	<tr>
				<td><%=doctor.getId()%></td>
				<td><%=doctor.getName()%></td>
				<td><%=doctor.getMobile()%></td>
				<td><%=doctor.getAge() %></td>
				<th><%=doctor.isStatus()%></th>	
				<th><a href="ChangeDoctorStatus?id=<%=doctor.getId()%>"><button>Change Status</button></a></th>
	       </tr>
	      
	      <%
            }
	      %>

	</table>
        <br>
	<a href="Admin_Home.html"><button>Back</button></a>
        
</body>
</html>