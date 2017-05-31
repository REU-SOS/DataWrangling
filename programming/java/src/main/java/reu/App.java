package reu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import reu.db.*;

/**
 * Connection to dataset.
 */
public class App 
{
	
	private static final String PROP_FILE = "config.properties";
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(PROP_FILE)) {
			prop.load(input);
        
		    AbstractConnection connection = new MySQLConnection();
		    connection.Init("DevInt", prop.getProperty("user"), prop.getProperty("pw"));

            ResultSet set = connection.Query("select * from Events");

			while( set.next() )
			{
				Date timestamp = set.getTimestamp("eventTime");
				int id = set.getInt("userId");
				String eventType = set.getString("eventType");
				
				System.out.println(timestamp + "," + id + "," + eventType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
}
