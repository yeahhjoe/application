package Application;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HomePage extends AbstractTableModel {
    private JPanel homePagePanel;
    private JTabbedPane tabbedPane1;
    private JLabel appName;
    private JLabel shortenAppName;
    private JButton checkInventoryButton;
    private JLabel redLamboImage;
    private JTable exampleTable;
    private JLabel leftCornerLabel;
    private JLabel middleBottomLabel;
    private JLabel bottomRightLabel;
    private JTextField searchBar;
    private JButton searchButton;
    private JButton shoppingCartButton;
    private JButton accountButton;
    private JLabel aboutUsLabel;
    private JLabel creatorsLabel;



    public static JFrame homePageFrame;




    HomePage() {



        DefaultTableModel model = (DefaultTableModel) exampleTable.getModel();

        Object[][] rowData = {
                {"1:64", "Toyota", "Die-Cast Metal"},
                {"1:43", "Audi", "Plastic"},
                {"1:24", "Lamborghini", "Resin"},
                {"1:18", "Bugatti", "Metal"},
                {"1:14", "Maserati", "Wood"},
                {"1:12", "Cadillac", "Steel"}
        };

        Object[] columnNames = {"Scales", "Car Brand", "Material"};



        model.setDataVector(rowData, columnNames);


        // text for the labels on the bottom of the page
        leftCornerLabel.setText("<html> <b>Shipping</b><br/>We offer overnight<br/>ground, and 3-day shipping</html>");
        middleBottomLabel.setText("<html><b>Exclusivity</b><br/> Our models are one of one<br/>once it has been purchased, it's gone</html>");
        bottomRightLabel.setText("<html><b>Refund</b><br/> If your model arrives damaged<br/> we offer refunds within 3 weeks of purchase</html>");


        //aboutUsLabel.setOpaque(true);
        //aboutUsLabel.setBackground(Color.GREEN);
        aboutUsLabel.setText("<html><font size = '6'> <b>About Us </b> </font> <br/> <font size = '4'> Welcome to Mini-Mobile! Here we sell unique, one-of-a kind miniature model cars.<br/> You will not find model cars like this anywhere else.<br/><br/> We guarantee the best services on your order.</font></html>");

        creatorsLabel.setText("<html> <font size = '4'> Application made by: Heriberto Contreas, Joseph Ohanu, Adam Tucker, Joshua Watson </font></html>");


    }

    public JPanel getHomePagePanel() {
        return homePagePanel;
    }


    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

}
