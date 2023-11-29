package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // This method connects to the database in the program
    public static Connection connect(){
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Database_Connection_Test.db");
            System.out.println("Connected!");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e + " ");
        }

        return con;
    }


}
