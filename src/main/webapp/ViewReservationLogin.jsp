<%@page import="com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Calendar"%>
<%@page import="com.csun.RobotDevTeamWorld.sql.construction.condition.ConditionBuilder"%>
<%@page import="com.csun.RobotDevTeamWorld.sql.construction.SQLBuilder"%>
<%@page import="com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success! </title>
<%
	String param_id = request.getParameter("ID");
	Integer id = param_id != null && !param_id.trim().equals("") ? Integer.parseInt(param_id) : null;%>
</head>
<body style="font-family: 'Trebuchet MS', sans-serif;">
<h1 align=center>Hello! Your Ticket:</h1> 
<hr/>
<br>
 <table border = "1" width="50%" height="100%" align="center" style="font-size:30px">
         <tr>
         	<th>ID</th>
            <th>Date</th> 
            <th>Park Hours</th>
            <th>Price</th>
         </tr>
         <%
         	if(id != null && id >= 0) {
         		Ticket ticket = new Ticket();
         		ticket.populate(SQLBuilder.select("Tickets").setCondition(ConditionBuilder.equals().setColumn("Id").setValue(id)));
         		Calendar[] calendar = Calendar.matchingList(SQLBuilder.select("Calendar"));
         		if(ticket.isValid() && calendar != null) {
	         		for(Calendar day : calendar)
		         		if(day.isValid() && day.getDate().equals(ticket.getDate())) {
		         			out.print("<tr><td>"+ticket.getID()+"</td>");
		         			out.print("<td>"+ticket.getDate()+"</td>");
		         			out.print("<td>"+day.getHrs()[0]+" - "+day.getHrs()[1]+"</td>");
		         			out.print("<td>$"+day.getPrice()+"</td></tr>");
		         			break;
		         		}
         		} else
         			out.print("<h1><center>Invalid Id or database is hybernating, please wait for a moment and refresh page</center></h1>");
         	}
         %>
   </table>
      <br>
       
</body>
</html>