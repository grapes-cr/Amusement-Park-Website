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


 <table border = "1" width="50%" height="100%" align="center" style="font-size:30px">
         <tr>
            <th>Date</th> 
            <th>Park Hours</th>
            <th>Price</th>
         </tr>
         <tr>
            <td>12/6</td>
            <td>10 AM - 6 PM</td>
            <td>$150</td> 
         </tr>
         <tr>
            <td>12/8</td>
            <td>11 AM - 12 AM</td>
            <td>$200</td>
         </tr>
      </table>
      <br>
      
       <center><form action="CartTest.jsp" method="post">
         <input type="submit" value="Purchase 12/6">&emsp;
         <input type="submit" value="Purchase 12/8"> 
         </form></center>
       
</body>
</html>