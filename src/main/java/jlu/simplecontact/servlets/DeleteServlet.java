package jlu.simplecontact.servlets;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jlu.simplecontact.dataaccess.JdbcAccess;
import jlu.simplecontact.models.Contact;
import jlu.simplecontact.models.ContactBuilder;

@WebServlet("/deleteContact")
public class DeleteServlet extends AbstractContactServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		loadContacts(req, "contacts");
		req.getRequestDispatcher("/WEB-INF/jsp/deleteContact.jsp").forward(req,
				resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doDelete(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long[] ids = prepareIds(req);
		int result = getContactDao().delete(ids);
		String message = (result > 0) ? "" + result + " contact(s) deleted" : "failed deleting contacts";
		req.setAttribute("message", message);
		req.getRequestDispatcher("/WEB-INF/jsp/confirmation.jsp").forward(req,
				resp);

	}

	private long[] prepareIds(HttpServletRequest req) throws ServletException {
		String selection = req.getParameter("selections");
		try {
			if (selection.equals("")) {throw new InvalidParameterException("selection empty");}
			String[] selections = selection.split(",");
			return Arrays.stream(selections).mapToLong(Long::parseLong).toArray();
		}
		catch (InvalidParameterException | NumberFormatException  | NullPointerException e) {
			e.printStackTrace();
			throw new ServletException("invalid delete parameter" + selection);
		}
	}
}
