package Application.Inventory;

import Application.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InventoryPage {
    private JPanel inventoryPanel;
    private JTable inventoryTable;
    private JLabel appName;
    private JButton cartButton;
    private JButton searchButton;
    private JButton accountButton;

    public static JFrame inventoryPageJframe;

    public static List<InventoryItem> inventoryItems;

    DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();

    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }

    private void initializeUI(List<InventoryItem> inventoryItems){
        Object[][] data = new Object[inventoryItems.size()][4];


        String[] columnNames = {"Name", "Price", "Description", "Image"};

        model.addColumn("Name");
        //model.addColumn("Image");
        model.addColumn("Price");
        model.addColumn("Description");

        for(InventoryItem item: inventoryItems){
            model.addRow(item.toObjectArray());
        }

        //inventoryTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
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
