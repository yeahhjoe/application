package Application.Inventory;

import Application.DatabaseConnection;
import Application.Home.HomePage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

public class InventoryPage {
    private JPanel inventoryPanel;
    private JTable inventoryTable;

    public static JFrame inventoryPageJframe;

    public static List<InventoryItem> inventoryItems;

    DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();

    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }

    private void initializeUI(List<InventoryItem> inventoryItems){
        Object[][] data = new Object[inventoryItems.size()][4];

        for(int i = 0; i < inventoryItems.size(); i++){
            InventoryItem item = inventoryItems.get(i);
            data[i][0] = item.getName();
            data[i][1] = item.getPrice();
            data[i][2] = item.getDescription();

            try{
                Blob imageBlob = item.getImageBlob();
                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                data[i][3] = imageIcon;

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

        }
        String[] columnNames = {"Name", "Price", "Description", "Image"};

        model.setDataVector(data, columnNames);
    }





    InventoryPage(){





        inventoryItems = DatabaseConnection.getInventoryItems();

        initializeUI(inventoryItems);


    }

    public static void createAndShowGUI(){
        // Log the User in
        inventoryPageJframe = new JFrame("Home Page");
        inventoryPageJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryPageJframe.setSize(1300, 700);

        inventoryPageJframe.getContentPane().setBackground(Color.WHITE);

        // Create an instance of GUI class

        InventoryPage inventoryPage = new InventoryPage();


        // Set up the layout and add components
        inventoryPageJframe.add(inventoryPage.getInventoryPanel(), BorderLayout.CENTER);



        // Make the frame visible
        inventoryPageJframe.setVisible(true);
    }


}
