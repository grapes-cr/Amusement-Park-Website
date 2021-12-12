This is a Servlet we will be using to run a web server for our Amusement Park Ticket project. It will utilize the Microsoft Azure DB in order to hold tickets for an amusement park. We are using Apache Tomcat 8.6, Maven, and Eclipse.

Getting set up:
- [ ] Clone the repository.

1. `mkdir RobotDevTeamWorld (optional)`
2. `git clone (SSH or HTTP)`

Running RobotDevTeamWorld.java:
- Make sure to have Apache Tomcat 8.6 or 9.0 installed. If you are running an older version of Eclipse that isn't Java EE, see the next step.
- Configure settings so that Apache 8.6 is recognized as Apache 8.0 in Eclipse. Either patch Eclipse to recognize Apache 8.6 as Apache 9.0, or change version type in *[apache tomcat 8.6 folder]/lib/catalina.jar* to 8.0. See [this link](https://bugs.eclipse.org/bugs/attachment.cgi?id=262418&action=edit) for more info. 
- Add the Apache Tomcat library to the RobotDevTeamWorld folder. **Build Path > Configure Build Path > Libraries > Add Library > Server Runtime > Apache Tomcat 8.0/9.0**
- Select "Run on Server" -> "Apache Tomcat 8"

~~*Currently the web code is only called in the doGet() method of TestServlet.java. None of the other files (like the .jsp and .html are called).*~~
 
**UPDATE 11/22/21:** Servlet now calls Welcome Page *Welcome.jsp* and has a clickable link that calls the "next page" *SecondPage.jsp* :)
**UPDATE 11/29/21:** Servlet code is cleaned up + commented. Added design to the Welcome page. Welcome.jsp now calls 4 different .jsp files when links are clicked.
**UPDATE 12/11/21:** All main .jsp files are created, most UI designs are done. DB integrated but not merged with main.

