package Application.Inventory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class InventoryPage {
    private JPanel inventoryPanel;
    private JTable inventoryTable;

    public static List<InventoryItem> inventoryItems;





    InventoryPage(){
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "Image", "Description", "Price"}
        );

        inventoryTable = new JTable(tableModel){
            public Class<?> getColumnClass(int column) {
                return column == 3 ? ImageIcon.class : Object.class;
            }
        };

        inventoryTable.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

        for(InventoryItem item : inventoryItems){tableModel.addRow(item.toObjectArray());}




    }


}
