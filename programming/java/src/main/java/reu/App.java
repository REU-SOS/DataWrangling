package reu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

import reu.db.*;

/**
 * Connection to dataset.
 */
public class App 
{
	
	private static final String PROP_FILE = "config.properties";
	
	public static void insertUsers() {
        try {
		    DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();

            File f = new File("data/UserInfo.csv");
            Scanner in = new Scanner(f);
            //Skip first line
            in.nextLine();
			while (in.hasNextLine()) {
				String line = in.nextLine();
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");
				
				int id = lineScanner.nextInt();
				int numDays = lineScanner.nextInt();
				int numHours = lineScanner.nextInt();
				
				String query = "INSERT INTO Users(id, number_of_days, number_of_hours) values (?, ?, ?)";
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, id);
				stmt.setInt(2, numDays);
				stmt.setInt(3, numHours);
				stmt.executeUpdate();
				lineScanner.close();
			}
			in.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertEvents() {
		
		
	}
	
	public static void insertMessages() {
		
	}
	
	public static void queryUsers() {	
        
        try  {
        	DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();
		    
		    PreparedStatement stmt = conn.prepareStatement("select * from Users");
		    ResultSet set = stmt.executeQuery();

			while( set.next() )
			{
				int id = set.getInt("id");
				int numHours = set.getInt("number_of_hours");
				int numDays = set.getInt("number_of_days");
				
				System.out.println(id  + "," + numHours + "," + numDays);
			}
			
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        insertUsers();
        queryUsers();
        
    }
}
