package jlu.simplecontact.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jlu.simplecontact.models.Contact;

@WebServlet("/newContact")
public class NewServlet extends HttpServlet{

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
	
	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/newContact.jsp");
	rd.forward(req, resp);
	return;
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	Contact c = new Contact();
	req.setAttribute("contact", c);
	req.getRequestDispatcher("/WEB-INF/jsp/confirmation.jsp").forward(req, resp);
	return;
	}
}
