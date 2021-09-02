package ngoactivityportal;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
    
    private static Connection con;
    public static Connection getConnection(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","xe");
        }
        catch(Exception e){
            con = (Connection) e;
        }
        return con;
    }
}
