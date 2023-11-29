package Application;

import Application.Inventory.InventoryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<InventoryItem> getInventoryItems(){
        List<InventoryItem> inventoryItems = new ArrayList<>();

        try(Connection con = connect();
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Inventory")){

            while (resultSet.next()){
                InventoryItem item = new InventoryItem();
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setDescription(resultSet.getString("description"));
                item.setImageBlob(resultSet.getBlob("inventoryImage"));

                inventoryItems.add(item);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return inventoryItems;
    }


}
