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
            <th>Date</th> 
            <th>Park Hours</th>
            <th>Price</th>
            <th>Quantity</th>
         </tr>
         <tr>
            <td>12/6</td>
            <td>10 AM - 6 PM</td>
            <td>$150</td> 
            <td>1</td>
           
         </tr>
         <tr>
            <td>12/8</td>
            <td>11 AM - 12 AM</td>
            <td>$200</td>
            <td>1</td>
            
         </tr>
      </table>
      <br>
      </center>

<center>
 <button onclick="window.location.href='http://localhost:8080/RobotDevTeamWorld/Welcome.jsp';">
      Welcome Page
    </button>

 <button onclick="window.location.href='http://localhost:8080/RobotDevTeamWorld/Reserve-a-Ticket.jsp';">
      Reserve Another Ticket
    </button>
</body>
</html>

