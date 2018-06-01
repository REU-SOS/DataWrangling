package reu.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class DBConnection {
	
	private static final String PROP_FILE = "config.properties";
	
	private Connection conn;
	
	public DBConnection() {
		Properties prop = new Properties();
		
		try (InputStream input = new FileInputStream(PROP_FILE)){
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			prop.load(input);
			String url = "jdbc:mysql://" + prop.getProperty("host", "localhost") + ":" + 
			             prop.getProperty("port") + "/" + prop.getProperty("db") + "?useSSL=false";
			String user = prop.getProperty("user");
			String pw = prop.getProperty("pw");
			
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}		
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

