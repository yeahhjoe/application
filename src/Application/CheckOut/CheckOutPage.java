package Application.CheckOut;

import javax.swing.*;
import java.awt.*;

public class CheckOutPage extends JPanel {
    private JLabel applicationTitle;
    private JButton homePage;
    private JButton aboutPage;
    private JButton profilePage;
    private JRadioButton freeShipping;
    private JRadioButton threeDayShipping;
    private JRadioButton overNightShipping;
    private JButton next;
    private JTable cartInformation;
    private JTextField address;
    private JTextField zipCode;
    private JTextField phoneNumber;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField city;
    private JTextField state;
    private JTextField email;
    private JTextField cardNumber;
    private JTextField expDate;
    private JTextField cvv;

    public static JFrame checkOutPageFrame;

    public static JPanel checkOutPanel;
    ButtonGroup shippingTypes = new ButtonGroup();

    public CheckOutPage(){


        checkOutPageFrame = new JFrame();


        setPreferredSize(new Dimension(600, 400));

        //Picking the layout for the panel
        this.setLayout(new BorderLayout());

        //adding components to the top bar
        JPanel topButtons = new JPanel(new FlowLayout());
        applicationTitle = new JLabel("Mini-Mobile");
        topButtons.add(applicationTitle);
        homePage = new JButton("Home");
        topButtons.add(homePage);
        aboutPage = new JButton("About");
        topButtons.add(aboutPage);
        profilePage = new JButton("Profile");
        topButtons.add(profilePage);



        //adding components to the bottom bar
        JPanel bottomButtons = new JPanel(new FlowLayout());
        freeShipping = new JRadioButton("Free Shipping");
        threeDayShipping = new JRadioButton("3-Day Shipping");
        overNightShipping = new JRadioButton("Overnight Shipping");
        shippingTypes.add(freeShipping);
        shippingTypes.add(threeDayShipping);
        shippingTypes.add(overNightShipping);
        bottomButtons.add(freeShipping);
        bottomButtons.add(threeDayShipping);
        bottomButtons.add(overNightShipping);
        next = new JButton("FINISH PAYMENT");
        bottomButtons.add(next);



        //Adding the Shipping Information
        JPanel centerFilloutForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //gbc.weights = 1
        firstName = new JTextField("First Name");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        centerFilloutForm.add(firstName, gbc);

        lastName = new JTextField("Last Name");
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        centerFilloutForm.add(lastName, gbc);

        address = new JTextField("Address");
        gbc.gridy = 2;
        centerFilloutForm.add(address, gbc);

        city = new JTextField("City");
        gbc.gridy = 3;
        centerFilloutForm.add(city, gbc);

        state = new JTextField("State");
        gbc.gridy = 4;
        centerFilloutForm.add(city, gbc);

        zipCode = new JTextField("ZIP code");
        gbc.gridy = 5;
        centerFilloutForm.add(zipCode, gbc);

        phoneNumber = new JTextField("Phone Number");
        gbc.gridy = 6;
        centerFilloutForm.add(phoneNumber, gbc);

        email = new JTextField("Email");
        gbc.gridy = 7;
        centerFilloutForm.add(email, gbc);



        //Adding the Payment Information
        JPanel eastFilloutForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        cardNumber = new JTextField("Card Number");
        gbc2.gridy = 0;
        gbc2.gridx = 0;
        eastFilloutForm.add(cardNumber, gbc2);

        expDate = new JTextField("Exp Date: MM/YY");
        gbc2.gridy = 1;
        eastFilloutForm.add(expDate, gbc2);

        cvv = new JTextField("cvv");
        gbc2.gridy = 2;
        eastFilloutForm.add(cvv, gbc2);

        /*
        //Adding the sub Panel to main Panel
        cartInformation = new JTable();
        this.add(eastFilloutForm, BorderLayout.EAST);
        this.add(centerFilloutForm, BorderLayout.CENTER);
        this. add(cartInformation, BorderLayout.WEST);
        this.add(topButtons, BorderLayout.NORTH);
        this.add(bottomButtons, BorderLayout.SOUTH);

         */



        // Adding components to checkOutPageFrame
        checkOutPageFrame.add(topButtons, BorderLayout.NORTH);
        checkOutPageFrame.add(bottomButtons, BorderLayout.SOUTH);
        checkOutPageFrame.add(centerFilloutForm, BorderLayout.CENTER);
        checkOutPageFrame.add(eastFilloutForm, BorderLayout.EAST);
        checkOutPageFrame.add(cartInformation, BorderLayout.WEST);




        // Set frame properties
        checkOutPageFrame.setTitle("Checkout Page");
        checkOutPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkOutPageFrame.setSize(800, 600); // Set your preferred size
        checkOutPageFrame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create an instance of your CheckOutPage


        // Add CheckOutPage to the frame
        checkOutPageFrame.setVisible(true);


        // Make the frame visible
        //setVisible(true);

    }


}
