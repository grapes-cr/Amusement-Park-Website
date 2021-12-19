package com.csun.RobotDevTeamWorld.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csun.RobotDevTeamWorld.sql.construction.SQLBuilder;
import com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Calendar;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Calendar[] calendars = Calendar.matchingList(SQLBuilder.select("Calendar"));
		
		Object[][] data = new Object[calendars.length][3];
		for(int i=0;i<data.length;i++) {
			data[i][0] = calendars[i].getDate();
			data[i][1] = calendars[i].getHrs();
			data[i][2] = calendars[i].getPrice();
		}
		
		if(data != null && data.length != 0)
			request.setAttribute("calendar", data);
		
		getServletContext().getRequestDispatcher("/ReserveTicketLogin.jsp").forward(request, response);
	}

}
