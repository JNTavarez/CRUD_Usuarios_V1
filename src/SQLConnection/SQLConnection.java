package SQLConnection;
import java.sql.*;

// SQL connection using Singleton Pattern

public class SQLConnection {
    
    // Encapsulating atributes
   
    private String url;
    private String usuario;
    private String password;

    // Private & Static instance of connection
    
    private static Connection con = null;
    
    // Private constructor to be able to access on to our connection
    
    private SQLConnection(){
        
        url = "jdbc:mysql://localhost:3307/usuarios";
        usuario = "root";
        password = "";
 
        try{
            con = DriverManager.getConnection(url, usuario, password);
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    // To establish SQL connection
    
    public static Connection getConnection(){
        
        if(con == null){
            new SQLConnection();
        }
        
        return con;
    }
    
    // To close connection
    
    public static void closeConnection() throws SQLException{
        if(con != null){
            con.close();
        }
    }
}