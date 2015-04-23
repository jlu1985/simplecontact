package jlu.simplecontact.dataaccess;

import java.sql.Connection;

public abstract class AbstractJdbcAccess<T> implements BasicAccess<T>{

	private ConnectionManager connectionManager;
	
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}
	
	protected Connection getConnection(){
		return connectionManager.getConnection();
	}
	
}
