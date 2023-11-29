package Application;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Application.HomePage.homePageFrame;


public class LoginPage {

    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JLabel appName;
    private JLabel loginLabel;
    private JLabel doNotHaveAccountLabel;

    // TODO: Checks if there is a match in the database and log the user in
    public static boolean userExistInDatabase(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Connect to database
            connection = DatabaseConnection.connect();

            // SQL query to check if the username and password match
            String query = "SELECT COUNT(*) FROM User WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute query
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count == 1; // Return true if exactly one match is found
            }

        } catch (SQLException e) {
            System.out.println("Error occurred");
        } finally {
            // close the commands
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return false;
    }

    // method to close resources≥
    private static void close(AutoCloseable res) {
        if (res != null) {
            try {
                res.close();
            } catch (Exception e) {
                System.out.println("Error with closing");
            }
        }
    }



    public static String currentUsername;
    public static String currentPassword;


    public LoginPage() {
        // TODO: Grab the username and password and check in the database if there is a match
        loginButton.addActionListener(e -> {
            String username = usernameTextField.getText();
            char[] passwordChars = passwordPasswordField.getPassword();
            String password = String.valueOf(passwordChars);

            // keeps track of current user
            currentUsername = username;
            currentPassword = password;

            if (userExistInDatabase(username, password)) {
                // Log the User in
                homePageFrame = new JFrame("Home Page");
                homePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                homePageFrame.setSize(1300, 700);

                homePageFrame.getContentPane().setBackground(Color.WHITE);

                // Create an instance of GUI class

                HomePage homePage = new HomePage();


                // Set up the layout and add components
                homePageFrame.add(homePage.getHomePagePanel(), BorderLayout.CENTER);



                // Make the frame visible
                homePageFrame.setVisible(true);
                closePage(loginPageFrame);
            } else {
                JOptionPane.showMessageDialog(loginPageFrame, "User does not exist!");
            }
        });

        // TODO: When this button is clicked it generates a new Sign-Up page window
        signUpButton.addActionListener(e -> {
            // Set up the main frame
            SignUpPage.signUpPageFrame = new JFrame("Sign Up Page");
            SignUpPage.signUpPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SignUpPage.signUpPageFrame.setSize(1300, 700);

            // Create an instance of GUI class
            SignUpPage signUpPage = new SignUpPage();

            // Set up the layout and add components
            SignUpPage.signUpPageFrame.add(signUpPage.getSignUpPanel(), BorderLayout.CENTER);

            // Make the frame visible
            SignUpPage.signUpPageFrame.setVisible(true);

            // Close login page
            closePage(loginPageFrame);

        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::createAndShowGUI);
    }

    public static JFrame loginPageFrame;

    public static void createAndShowGUI() {
        // Set up the main frame
        loginPageFrame = new JFrame("Login Page");
        loginPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPageFrame.setSize(1300, 700);

        loginPageFrame.getContentPane().setBackground(Color.WHITE);

        // Create an instance of GUI class
        LoginPage loginPage = new LoginPage();

        // Set color for login button
        loginPage.loginButton.setContentAreaFilled(false);
        loginPage.loginButton.setForeground(Color.GREEN);

        // Set up the layout and add components
        loginPageFrame.add(loginPage.loginPanel, BorderLayout.CENTER);

        // Make the frame visible
        loginPageFrame.setVisible(true);


    }

    // This method closes the current page (frame)
    public static void closePage(JFrame frame) {
        if (frame != null) frame.dispose();
    }


}