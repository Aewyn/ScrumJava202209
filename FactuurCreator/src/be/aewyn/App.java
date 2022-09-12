package be.aewyn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel panelMain;
    private JButton buttonHours;
    private JTable tableHours;
    private JButton buttonEnd;

    public App() {
        String[] columnNames = {"Van", "Tot"};
        String[][] data = {{"test", "test"},{"test2", "test2"},{"test3", "test3"},{"test4", "test4"}};

        tableHours = new JTable(data, columnNames);
        tableHours.setEnabled(true);
        tableHours.setVisible(true);
        tableHours.setBounds(30,40,200,300);

        buttonHours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonHours.getText().equals("Start werkblok")) {
                    buttonHours.setText("Eindig werkblok");
                } else {
                    buttonHours.setText("Start werkblok");
                }
            }
        });

        buttonEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Save hours to excel file that can be pasted in workspace
                // TODO: Can only be done if at least one row is either complete and other rows are filled in or empty
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
