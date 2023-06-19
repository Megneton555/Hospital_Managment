<%@page import="java.util.List"%><%@page import="java.util.List"%>
<%@page import="dto.Staff"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Approve</title>
</head>
<body>
        
   
    <table border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Age</th>
		    <th>Status</th>
		    <th>changeStatus</th>
		</tr>
         
          <% List<Staff> list=(List<Staff>) request.getAttribute("list");
	         for(Staff staff:list){
	      %>
	      	<tr>
				<td><%=staff.getId()%></td>
				<td><%=staff.getName()%></td>
				<td><%=staff.getMobile()%></td>
				<td><%=staff.getAge() %></td>
				<td><%=staff.isStatus() %></td>
                <th><a href="ChangeStaffStatus?id=<%=staff.getId()%>"><button>Change Status</button></a></th>	 
	       </tr>
	      
	      <%
            }
	      %>

	</table>
	<br>
	<a href="Admin_Home.html"><button>Back</button></a>
        
</body>
</html>