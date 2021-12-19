<%@page import="com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.csun.RobotDevTeamWorld.sql.construction.SQLBuilder"%>
<%@page import="com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="com.csun.RobotDevTeamWorld.sql.construction.SQLUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Robot Dev Team World: Checkout</title>
</head>
<body style="font-family: 'Trebuchet MS', sans-serif;">
<h1 align=center>Checkout</h1>
<hr/>
<p><b>Your Cart:</b></p>
<br>
<center><table border = "1" width="50%" height="100%" align="center" style="font-size:30px">
         <tr>
         	<th>ID</th>
            <th>Date</th> 
            <th>Park Hours</th>
            <th>Price</th>
         </tr>
         <%
         	String param_date = request.getParameter("c0");
         	ArrayList<Calendar> days = new ArrayList<Calendar>();
         	for(int i=0; i<10; i++) {
         		if(param_date!=null && !param_date.trim().equals("")) {
         			Date date = SQLUtil.parseDate(param_date);
         			Calendar[] calendar = Calendar.matchingList(SQLBuilder.select("Calendar"));
         			if(calendar != null && calendar.length > 0) {
         				boolean once = true;
	         			for(Calendar day : calendar) {
	         				if(once && day.getDate().equals(date)) {
	         					days.add(day);
	         					once = false;
	         				}
	         			}
         			}
         		}
         		param_date = request.getParameter("c"+(i+1));
         	}
         	
         	Ticket[] tickets = Ticket.matchingList(SQLBuilder.select("Tickets"));
         	int id = -1;
         	for(Ticket ticket : tickets)
         		if(ticket.getID() > id)
         			id = ticket.getID();
         	
         	id+=(Math.random()*10)+1;
         	
         	if(days.size()!=0)
	         	for(Calendar day : days) {
	         		Ticket newTicket = new Ticket(id++, day.getDate());
	         		
	         		newTicket.post(SQLBuilder.insert("Tickets"));
	         		
	         		out.print("<tr><th>"+newTicket.getID()+"</th>");
	         		out.print("<th>"+newTicket.getDate()+"</th>");
	         		out.print("<th>"+day.getHrs()[0]+" - "+day.getHrs()[1]+"</th>");
	         		out.print("<th>$"+day.getPrice()+"</th></tr>");
	         	}
         	
         %>
      </table>
      <br>
      </center>
      <center><p><b>Before checking out, be sure to write your ticket IDs down!</b></p></center>
      <form action="Welcome.jsp" method="post">
      <center><input type="submit" value="Checkout and Return to Welcome Page"/></center>
</body>
</html>