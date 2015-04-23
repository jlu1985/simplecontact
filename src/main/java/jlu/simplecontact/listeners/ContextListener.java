package jlu.simplecontact.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import jlu.simplecontact.dataaccess.ConnectionManager;


public class ContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("connectionManager", new ConnectionManager());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
