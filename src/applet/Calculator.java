package applet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
    private JTextField textField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton clearButton;
    private double result;
    private String lastCommand;
    private boolean start;

    public Calculator() {
        // Set the frame properties
        setSize(300, 300);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel and set its layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));

        // Create the buttons for the digits
        for (int i = 0; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            panel.add(button);
            // Add an action listener to the button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Append the button's text to the text field
                    if (start) {
                        textField.setText("");
                        start = false;
                    }
                    textField.setText(textField.getText() + button.getText());
                }
            });
        }

        // Add the buttons for the operations
        addButton = new JButton("+");
        panel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeOperation("+");
            }
        });

        subtractButton = new JButton("-");
        panel.add(subtractButton);
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeOperation("-");
            }
        });

        multiplyButton = new JButton("*");
        panel.add(multiplyButton);
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeOperation("*");
            }
        });

        divideButton = new JButton("/");
        panel.add(divideButton);
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeOperation("/");
            }
        });

        // Add the button for equals
        equalsButton = new JButton("=");
        panel.add(equalsButton);
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeOperation("=");
            }
        });

        // Add the button for clear
        clearButton = new JButton("Clear");
        panel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result = 0;
                lastCommand = "";
                textField.setText("");
                start = true;
            }
        });

        // Add a text field and the panel to the frame
        textField = new JTextField();
        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    private void executeOperation(String command) {
        if (lastCommand.equals("+")) {
            result += Double.parseDouble(textField.getText());
        } else if (lastCommand.equals("-")) {
            result -= Double.parseDouble(textField.getText());
        } else if (lastCommand.equals("*")) {
            result *= Double.parseDouble(textField.getText());
        } else if (lastCommand.equals("/")) {
            result /= Double.parseDouble(textField.getText());
        } else {
            result = Double.parseDouble(textField.getText());
        }

        textField.setText("");
        lastCommand = command;
        start = true;
    }
}
