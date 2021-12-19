<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Robot Dev Team World: View a Reservation</title>
</head>
<body style="font-family: 'Trebuchet MS', sans-serif;">
<h1 align=center>View Your Current Reservations</h1>
<b>In order to view your tickets, please Login.</b>

<hr/>  
  
<h3>Login to Robot Dev Team World</h3>  
  
 <br/>  
<form action="ViewReservationLogin.jsp" method="post">  
Ticket ID:&emsp;&nbsp;&nbsp;<input type="number" id="ID" name= "ID" min="0" max="<% out.print(Integer.MAX_VALUE); %>"/><br/><br/>
<input type="submit" value="Login"/>  
</form>

</body>
</html>