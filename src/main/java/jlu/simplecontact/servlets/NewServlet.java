package jlu.simplecontact.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jlu.simplecontact.models.Contact;
import jlu.simplecontact.models.ContactBuilder;

@WebServlet("/newContact")
public class NewServlet extends AbstractContactServlet{

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
	
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String phone = req.getParameter("phone");
	
	Contact newContact = ContactBuilder.newInstance().name(name).email(email).phone(phone).build();
	
	String message = (getContactDao().create(newContact))?"New ontact added":"failed adding contact";
	
	req.setAttribute("message", message);
	req.getRequestDispatcher("/WEB-INF/jsp/confirmation.jsp").forward(req, resp);
	return;
	}
}
