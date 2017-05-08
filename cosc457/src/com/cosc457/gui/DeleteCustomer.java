package com.cosc457.gui;

import com.cosc457.data.CustomerApi;
import com.cosc457.models.Customer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/8/2017.
 */
public class DeleteCustomer extends JPanel {
    private JPanel panel1;
    private JTextField ssnField;
    private JButton deleteButton;
    private JButton backButton;

    public DeleteCustomer(){
        initDeleteButton();
        deleteButton.setEnabled(false);

        ssnField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            private void changed()
            {
                if (ssnField.getText().equals(""))
                {
                    deleteButton.setEnabled(false);
                }
                else
                {
                    deleteButton.setEnabled(true);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Navigation.getInstance().goBack(panel1);
            }
        });
    }

    public JPanel getPanel(){
        return panel1;
    }

    private void initDeleteButton(){
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String CustomerDeleted = ssnField.getText() + " has been removed from the database.";
                JOptionPane.showMessageDialog(null, CustomerDeleted);
                CustomerApi.deleteCustomerViaSSN(new Customer(ssnField.getText()));
            }
        });
    }

}
