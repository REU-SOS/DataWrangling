package reu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Connection to a MySQL database.
 */
public class MySQLConnection extends AbstractConnection
{
	/** MySQL driver */
	private String driver = "com.mysql.cj.jdbc.Driver";
	/** Database name */
	private String dbName = null;
	/** Instance of a connection */
	private Connection conn = null;

	/** SQL statement object */
	private Statement _commonStatement;

	/**
	 * Initializes the connection to the given database using the user and password.
	 * @param db database to connect to
	 * @param user username to authenticate with
	 * @param pass password to authenticate with
	 */
	public void init(String db, String user, String pass)
	{
		try 
		{
			this.dbName = db;
			String connectionURL = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&" + "useLegacyDatetimeCode=false&serverTimezone=America/New_York";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(connectionURL, user, pass);
			_commonStatement = conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY,java.sql.ResultSet.CONCUR_READ_ONLY);
			_commonStatement.setFetchSize(Integer.MIN_VALUE);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a java.sql.ResultSet containing the result of the given query.
	 * @param q query to run on the database
	 * @return result of the query
	 */
	public ResultSet query(String query)
	{
		try 
		{
			return _commonStatement.executeQuery(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Closes the database connection when done.
	 */
	public void close() {
		try 
		{
			_commonStatement.close();
			conn.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
