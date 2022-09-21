
package inventory.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    
    public static Connection mycon() {
    
        Connection con = null ;
        
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/posdb","root","root");
            return con;
            
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println(e);
            return null;
            
        }
    
    
    
    }
  
}
