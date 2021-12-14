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
          <td>2021-12-17</td>
            <td>8-8</td>
            <td>175.0</td> 
            <td>1</td>
           
         </tr>
         <tr>
            <td>2021-12-18</td>
            <td>8-8</td>
            <td>175.0</td>
            <td>1</td>
         </tr>
      </table>
      <br>
      </center>

<center>
 <button onclick="window.location.href='http://localhost:8080/RobotDevTeamWorld/Welcome.jsp';">
      Return to Welcome Page
    </button>

 <button onclick="window.location.href='http://localhost:8080/RobotDevTeamWorld/Reserve-a-Ticket.jsp';">
      Purchase and Reserve Another Ticket
    </button>
</body>
</html>

