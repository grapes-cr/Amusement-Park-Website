package com.csun.RobotDevTeamWorld.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csun.RobotDevTeamWorld.sql.construction.SQLBuilder;
import com.csun.RobotDevTeamWorld.sql.construction.SQLUtil;
import com.csun.RobotDevTeamWorld.sql.construction.datacarrier.Ticket;

/**
 * Servlet implementation class RobotDevTeamWorld
 */
@WebServlet("/RobotDevTeamWorld")
public class RobotDevTeamWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RobotDevTeamWorld() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath()); //Pulls up the welcome page, Welcome.jsp.
		Ticket ticket = new Ticket(5,SQLUtil.parseDate("2021-12-06"));
		ticket.post(SQLBuilder.insert("Tickets"));

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		
	}

}
