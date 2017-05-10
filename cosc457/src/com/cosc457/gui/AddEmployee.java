package com.cosc457.gui;

import com.cosc457.data.SalesPeopleApi;
import com.cosc457.models.SalesPeople;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JPanel{
    private JPanel panel1;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField hireField;
    private JButton saveButton;
    private JButton backButton;
    private JTextField dobField;
    private JTextField salaryField;
    private JTextField phoneField;
    private JTextField emailField;


    public AddEmployee(){
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
                    String newEmployeeCreated = firstNameField.getText() + " " + lastNameField.getText() + " has been added to the database.";
                    JOptionPane.showMessageDialog(null, newEmployeeCreated);
                    SalesPeopleApi.saveSalesPeople(new SalesPeople(firstNameField.getText(), lastNameField.getText(),
                            salaryField.getText(), dobField.getText(), hireField.getText(), phoneField.getText(), emailField.getText()));
            }
        });
    }
}
