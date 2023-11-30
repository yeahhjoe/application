package Application.Cart;

import Application.Inventory.InventoryItem;
import Application.Inventory.InventoryPage;
import Application.Login.LoginPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CartPage {
    private JLabel cartOverviewLabel;
    private JLabel itemsInCartLabel;
    private JScrollPane scrollPane;
    private JTable itemsInCartTable;
    private JPanel cartPanel;
    private JButton backToInventoryPage;

    public JPanel getCartPanel() {
        return cartPanel;
    }

    public static JFrame cartJFrame;

    CartPage(){
        initializeUI(Cart.itemsInCart);

        backToInventoryPage.addActionListener(e ->{
            InventoryPage.createAndShowGUI();
            LoginPage.closePage(cartJFrame);
        });


    }


    private void initializeUI(HashSet<List<InventoryItem>> a){

        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };

        //model.setColumnCount(0);

        model.addColumn("Item");
        model.addColumn("Name");

        model.addColumn("Price");
        model.addColumn("Description");

        Iterator<List<InventoryItem>> it = a.iterator();
        for(int i = 0; i < a.size(); i++){
            while(it.hasNext()){
                model.addRow(it.next().get(i).toObjectArray());
            }
        }

        itemsInCartTable.setModel(model);
        itemsInCartTable.setRowHeight(50);




        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


    }




    public static void createAndShowGUI(){
        // Log the User in
        cartJFrame = new JFrame("Home Page");
        cartJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartJFrame.setSize(1300, 700);

        cartJFrame.getContentPane().setBackground(Color.WHITE);

        // Create an instance of GUI class


        CartPage cartPage = new CartPage();


        // Set up the layout and add components
        cartJFrame.add(cartPage.getCartPanel(), BorderLayout.CENTER);



        // Make the frame visible
        cartJFrame.setVisible(true);
    }
}
