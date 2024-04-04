//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardingSystemGUI extends JFrame implements ActionListener {
    private JTextField nameField, seatField;
    private JButton submitButton;
    private JTextArea displayArea;
    private String[] seats = new String[10];

    public BoardingSystemGUI() {
        setTitle("Boarding System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Name: "));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Room Number: "));
        seatField = new JTextField();
        inputPanel.add(seatField);

        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        buttonPanel.add(submitButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        add(inputPanel);
        add(buttonPanel);
        add(new JScrollPane(displayArea));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            int roomNumber = Integer.parseInt(seatField.getText());
            if (roomNumber >= 0 && roomNumber < 10 && seats[roomNumber] == null) {
                seats[roomNumber] = name;
                displayArea.append(name + " has been assigned to seat " + roomNumber + ".\n");
            } else {
                displayArea.append("Seat " + roomNumber + " is already taken or invalid.\n");
            }
        }
    }

    public static void main(String[] args) {
        new BoardingSystemGUI();
    }
}