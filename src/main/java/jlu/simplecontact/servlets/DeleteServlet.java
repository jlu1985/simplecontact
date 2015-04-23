package jlu.simplecontact.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jlu.simplecontact.models.Contact;
import jlu.simplecontact.models.ContactBuilder;

@WebServlet("/deleteContact")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Contact> records = new ArrayList<>();
		
		records.add(ContactBuilder.newInstance().id(1).name("a").build());
		records.add(ContactBuilder.newInstance().id(2).name("b").build());
		records.add(ContactBuilder.newInstance().id(3).name("c").build());
		
		req.setAttribute("records", records);
		req.getRequestDispatcher("/WEB-INF/jsp/deleteContact.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doDelete(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("message", "how many deleted");
		req.getRequestDispatcher("/WEB-INF/jsp/confirmation.jsp").forward(req, resp);
	}
}
