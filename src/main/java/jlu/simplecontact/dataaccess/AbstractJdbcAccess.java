package jlu.simplecontact.dataaccess;

import java.sql.Connection;

public abstract class AbstractJdbcAccess<T> implements BasicAccess<T>{

	private final ConnectionManager connectionManager;
	
	public AbstractJdbcAccess(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}
	
	protected Connection getConnection(){
		return connectionManager.getConnection();
	}
	
}
