<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
         <%if(session.getAttribute("staff")==null)
{
	response.getWriter().print("<h1 style='color:red'>Session Expired Login Again</h1>");
	request.getRequestDispatcher("login.html").include(request, response);
}else{
	%>
  <form action="addpatient" method="post" enctype="multipart/form-data">
         <p>
            <label>Name</label><br>
            <input type="text" name="name" placeholder="Entert your name" required>
         </p>

         <p>
            <label>Mobile</label><br>
            <input type="number" name="number" placeholder="Enter your mobile Number" required>
         </p>

         <p>
             <label>DOB</label><br>
             <input type="date" name="dob" required>
         </p>

         <p>
            <label>Picture</label>
            <input type="file" name="image" required>
         </p>

         <p>
            <button type="submit">Add</button> <button type="reset">cancel</button>
         </p>
       </form>
       
<%
   } 
%>
</body>
</html>