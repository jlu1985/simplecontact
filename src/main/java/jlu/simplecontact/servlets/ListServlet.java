package jlu.simplecontact.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/listContacts")
public class ListServlet extends AbstractContactServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loadContacts(request, "contacts");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listContact.jsp");
		dispatcher.forward(request, response);
		return;
	}
}
