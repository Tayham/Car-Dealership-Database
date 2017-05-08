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
public class AddCustomer extends JPanel{
    private JPanel panel1;
    private JTextField ssnField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton saveButton;
    private JButton backButton;
    private JTextField phoneField;
    private JTextField emailField;


    public AddCustomer(){
        initSaveButton();
        saveButton.setEnabled(false);

        firstNameField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (firstNameField.getText().equals("") || lastNameField.getText().equals(""))
                {
                    saveButton.setEnabled(false);
                }
                else
                {
                    saveButton.setEnabled(true);
                }
            }
        });

        lastNameField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (firstNameField.getText().equals("") || lastNameField.getText().equals(""))
                {
                    saveButton.setEnabled(false);
                }
                else
                {
                    saveButton.setEnabled(true);
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

    private void initSaveButton(){
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String newCustomerCreated = firstNameField.getText() + " " + lastNameField.getText() + " has been added to the database.";
                JOptionPane.showMessageDialog(null, newCustomerCreated);
                CustomerApi.saveCustomer(new Customer(ssnField.getText(), firstNameField.getText(), lastNameField.getText(), phoneField.getText(), emailField.getText()));
            }
        });
    }
}
