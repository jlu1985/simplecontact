package jlu.simplecontact.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import jlu.simplecontact.dataaccess.JndiConnectionManager;
import jlu.simplecontact.dataaccess.JdbcAccess;

@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		JndiConnectionManager cm = new JndiConnectionManager();
		ctx.setAttribute("connectionManager", cm);
		ctx.setAttribute("contactDao", new JdbcAccess(cm));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
