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

<form action="CartTest.jsp" method="post">
 <table border = "1" width="50%" height="100%" align="center" style="font-size:30px">
         <tr>
            <th>Date</th> 
            <th>Park Hours</th>
            <th>Price</th>
            <th></th>
         </tr>
         <tr>
            <td>12/6</td>
            <td>10 AM - 6 PM</td>
            <td>$150</td> 
            <td><input type="checkbox" id="c1" name="c1" value="ticket1"></td>
         </tr>
         <tr>
            <td>12/8</td>
            <td>11 AM - 12 AM</td>
            <td>$200</td>
            <td><input type="checkbox" id="c2" name="c2" value="ticket2"></td>
            
         </tr>
      </table>
  <br>
       <center><input type="submit" value="Checkout"></center>
       </form>
       
</body>
</html> 
