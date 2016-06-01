package reu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection extends AbstractConnection
{
	private String driver = "com.mysql.jdbc.Driver";
	private String dbName=null;
	private String connectionURL = "jdbc:mysql://localhost:3306/" + dbName;
	private Connection conn = null;

	Statement _commonStatement;

	public void Init(String db, String user, String pass)
	{
		try 
		{
			this.dbName = db;
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
}
