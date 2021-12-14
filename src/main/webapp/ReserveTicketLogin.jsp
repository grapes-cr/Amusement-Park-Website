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
         <tr>
            <td>${lol[0].getDate()}</td>
            <td>${lol[0].getHrs()[0]}-${lol[0].getHrs()[1]}</td>
            <td>${lol[0].getPrice()}</td> 
            <td><input type="checkbox" id="c1" name="c1" value="ticket1"></td>
         </tr>

           <tr>
            <td>${lol[1].getDate()}</td>
            <td>${lol[1].getHrs()[0]}-${lol[1].getHrs()[1]}</td>
            <td>${lol[1].getPrice()}</td> 
            <td><input type="checkbox" id="c2" name="c2" value="ticket2"></td>
           </tr>
           
             <tr>
            <td>${lol[2].getDate()}</td>
            <td>${lol[2].getHrs()[0]}-${lol[2].getHrs()[1]}</td>
            <td>${lol[2].getPrice()}</td> 
            <td><input type="checkbox" id="c3" name="c3" value="ticket3"></td>
           </tr>
           
            <tr>
            <td>${lol[3].getDate()}</td>
            <td>${lol[3].getHrs()[0]}-${lol[3].getHrs()[1]}</td>
            <td>${lol[3].getPrice()}</td> 
            <td><input type="checkbox" id="c4" name="c4" value="ticket3"></td>
           </tr>
           
           <tr>
            <td>${lol[4].getDate()}</td>
            <td>${lol[4].getHrs()[0]}-${lol[4].getHrs()[1]}</td>
            <td>${lol[4].getPrice()}</td> 
            <td><input type="checkbox" id="c5" name="c5" value="ticket4"></td>
           </tr>
           
      </table>
  <br>
       <center><input type="submit" value="Checkout"></center>
       </form>
       
</body>
</html> 
