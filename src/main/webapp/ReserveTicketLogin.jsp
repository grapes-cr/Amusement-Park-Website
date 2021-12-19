<%@page import="com.csun.RobotDevTeamWorld.sql.construction.SQLBuilder"%>
<%@page import="com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success! </title>
<%String name = request.getParameter("name");%>
</head>
<body style="font-family: 'Trebuchet MS', sans-serif;">
<h1 align=center>Hello, <%out.print(name);%>! Reserve a Ticket!</h1> 
<hr/>
<p><b>Available tickets:</b></p><br>

<form action="Checkout.jsp" method="post">
 <table border = "1" width="50%" height="100%" align="center" style="font-size:30px">
         <tr>
            <th>Date</th> 
            <th>Park Hours</th>
            <th>Price</th>
            <th></th>
         </tr>
         <%
         	Calendar[] calendar = Calendar.matchingList(SQLBuilder.select("Calendar"));
         	if(calendar != null)
         		for(int i = 0; i < Math.min(10,calendar.length);i++){
         			Calendar day = calendar[i];
	         		if(day != null && day.isValid()){
	         			out.print("<tr><td>"+day.getDate().toString()+"</td>");
	             		out.print("<td>"+day.getHrs()[0].toString()+" - "+day.getHrs()[1].toString()+"</td>");
	             		out.print("<td>$"+day.getPrice().toString()+"</td>");
	             		out.print("<td><input type=\"checkbox\" id=\"c"+i+"\" name=\"c"+i+"\" value=\""+day.getDate().toString()+"\"></td>");
	         		}
         		}
         %>
      </table>
  <br>
       <center><input type="submit" value="Checkout"></center>
       </form>
       
</body>
</html> 
