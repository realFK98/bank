package bankingapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * BankingConnection
 */
public class BankingConnection {
    
   
    public static Connection connect(){
    String url = "jdbc:mysql://localhost:3306/mydb2";
    String username = "root";
    String password = "mysql@sit";
    Connection connection = null;

    try {
        connection = DriverManager.getConnection(url, username,password);
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return connection;
    }

}