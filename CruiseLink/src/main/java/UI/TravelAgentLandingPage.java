package UI;

import javax.swing.*;
import java.awt.*;

public class TravelAgentLandingPage {

    private JLabel travelAgentLabel;
    private JButton viewRoomStatusButton;
    private JButton modifyReservationButton;
    private JButton processCheckInOutButton;
    private JButton generateBillingInfoButton;
    private JButton makeReservationButton;
    private JButton cancelReservationButton;
    private JButton modifyProfileButton;

    private UINavigator UINavigator;

    public TravelAgentLandingPage(UINavigator UINavigator) {
        this.UINavigator = UINavigator;
    }

    public JPanel createTravelAgentLandingPanel() {

        //Initialize a new JPanel with a GridBagLayout manager for layout of components
        JPanel travelAgentLandingPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Initialize the JLabel with text and set its font
        travelAgentLabel = new JLabel("Travel Agent Landing Page");
        travelAgentLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

        //Set the grid position and layout constraints for the label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        //Add the label to the panel with the constraints
        travelAgentLandingPanel.add(travelAgentLabel, gbc);

        //Create and add buttons
        viewRoomStatusButton = addButton("View Room Status", travelAgentLandingPanel, gbc, 1);
        modifyReservationButton = addButton("Modify Reservation", travelAgentLandingPanel, gbc, 2);
        processCheckInOutButton = addButton("Process Check-In/Out", travelAgentLandingPanel, gbc, 3);
        generateBillingInfoButton = addButton("Generate Billing Information", travelAgentLandingPanel, gbc, 4);
        makeReservationButton = addButton("Make a Reservation", travelAgentLandingPanel, gbc, 5);
        cancelReservationButton = addButton("Cancel Reservation", travelAgentLandingPanel, gbc, 6);
        modifyProfileButton = addButton("Modify Profile", travelAgentLandingPanel, gbc, 7);

        //Set action listeners for each button
        viewRoomStatusButton.addActionListener(e -> System.out.println("Viewing Room Status"));
        modifyReservationButton.addActionListener(e -> System.out.println("Modifying Reservation"));
        processCheckInOutButton.addActionListener(e -> System.out.println("Processing Check-In/Out"));
        generateBillingInfoButton.addActionListener(e -> System.out.println("Generating Billing Information"));
        makeReservationButton.addActionListener(e -> System.out.println("Making a Reservation"));
        cancelReservationButton.addActionListener(e -> System.out.println("Cancelling Reservation"));
        modifyProfileButton.addActionListener(e -> System.out.println("Modifying Profile"));

        //Return the panel
        return travelAgentLandingPanel;
    }

    //Helper method to add a button to the panel
    private JButton addButton(String text, JPanel panel, GridBagConstraints gbc, int yPos) {
        JButton button = new JButton(text);
        gbc.gridx = 0;
        gbc.gridy = yPos;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(button, gbc);
        return button;
    }
}