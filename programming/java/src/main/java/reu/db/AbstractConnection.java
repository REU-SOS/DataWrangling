package reu.db;

import java.sql.ResultSet;

/**
 * Represents a database connection.
 */
public abstract class AbstractConnection 
{
	/**
	 * Initializes the connection to the given database using the user and password.
	 * @param db database to connect to
	 * @param user username to authenticate with
	 * @param pass password to authenticate with
	 */
	public abstract void init(String db, String user, String pass);
	
	/**
	 * Returns a java.sql.ResultSet containing the result of the given query.
	 * @param q query to run on the database
	 * @return result of the query
	 */
	public abstract ResultSet query(String q);
	
	/**
	 * Closes the database connection when done.
	 */
	public abstract void close();
}
