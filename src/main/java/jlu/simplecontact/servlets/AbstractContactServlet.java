package jlu.simplecontact.servlets;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import jlu.simplecontact.dataaccess.BasicAccess;
import jlu.simplecontact.dataaccess.ConnectionManager;
import jlu.simplecontact.dataaccess.JdbcAccess;
import jlu.simplecontact.models.Contact;

public class AbstractContactServlet extends HttpServlet {

	protected BasicAccess<Contact> getContactDao() {
		BasicAccess<Contact> contactDao = (BasicAccess<Contact>) getServletContext()
				.getAttribute("jdbcAccess");
		if (contactDao != null) {
			return contactDao;
		} else {
			ConnectionManager cm = (ConnectionManager) getServletContext().getAttribute("connectionManager");
			return new JdbcAccess(cm); 
		}

	}
	
	protected HttpServletRequest loadContacts(final HttpServletRequest req, String name) {
		req.setAttribute(name, getContactDao().find());
		return req;
		
	}
	
}
