

package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Edwin Martinez
 */
public class MyConnection {
    
    
    
     public static Connection getConnection() {
        Connection con = null;
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edenpharmacy","root","Erwin123456");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return con;
    }
     
     
    
}
