package reu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import reu.db.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        AbstractConnection connection = new MySQLConnection();
        connection.Init("ProductHunt", "root", "bacon");
        
        try 
        {
            ResultSet set = connection.Query("Select * from Posts");

			while( set.next() )
			{
				int id = set.getInt("id");
				Date time = set.getTimestamp("created_at");
				String comments_count = set.getString("tagline");
				
				System.out.println(id + "," + time + "," + comments_count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
