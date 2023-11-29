package Application.Inventory;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.Blob;
import java.sql.SQLException;

public class InventoryItem {
    private String name;
    private String description;
    private double price;
    private Blob imageBlob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Blob getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(Blob imageBlob) {
        this.imageBlob = imageBlob;
    }

    // method that converts the BLOB to ImageIcon
    public ImageIcon getImageIcon(){
        try{
            byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
            return new ImageIcon(imageBytes);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Method to convert an InventoryItem to an Object array (for table model)
    public Object[] toObjectArray(){
        return new Object[]{name, getImageIcon(), price, description};
    }


}

class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        if (value instanceof ImageIcon imageIcon) {
            label.setIcon(new ImageIcon(
                    imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        }
        return label;
    }
}
