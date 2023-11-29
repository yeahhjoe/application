package Application;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountPage {
    private JPanel panel1;
    private JLabel accountLabel;
    private JLabel detailLabel;
    private JLabel usernameLabel;
    private JLabel accountTypeLabel;

    // Check if the user is an admin
    public static boolean isAdmin(int userId) {
        Connection connection = DatabaseConnection.connect();
        if (connection == null) {
            // Handle connection error
            return false;
        }

        String query = "SELECT isAdmin FROM User WHERE UserId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // User found, check if isAdmin is true
                    return resultSet.getBoolean("isAdmin");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        } finally {
            // Close the connection if needed
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }

        // User not found or not an admin
        return false;
    }


    AccountPage(){
        usernameLabel.setText("<html> <font size = '5'> Username: " + LoginPage.currentUsername+ "</font></html>");

        // Checks if the user is admin or not
        if(isAdmin(LoginPage.currentUserId)){
            accountLabel.setText("<html><font size = '5'> Account Type: Admin</font></html>");
        }else{
            accountLabel.setText("<html><font size = '5'> Account Type: User</font></html>");
        }


    }
}
