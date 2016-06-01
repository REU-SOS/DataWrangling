package reu;

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
        connection.Init("ProductHunt", "", "");
        
        
    }
}
