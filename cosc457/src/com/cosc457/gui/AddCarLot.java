package com.cosc457.gui;

import com.cosc457.data.CarApi;
import com.cosc457.data.CarLotApi;
import com.cosc457.models.Car;
import com.cosc457.models.CarLot;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/7/2017.
 */
public class AddCarLot extends JPanel {
    private JPanel panel1;
    private JButton saveButton;
    private JButton backButton;
    private JTextField addressField;
    private JTextField capacityField;
    private JTextField nameField;



    public AddCarLot(){
        initSaveButton();
        saveButton.setEnabled(false);

        addressField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (addressField.getText().equals("") || nameField.getText().equals("")||capacityField.getText().equals(""))
                {
                    saveButton.setEnabled(false);
                }
                else
                {
                    saveButton.setEnabled(true);
                }
            }
        });

        nameField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (addressField.getText().equals("") || nameField.getText().equals("")|| capacityField.getText().equals(""))
                {
                    saveButton.setEnabled(false);
                }
                else
                {
                    saveButton.setEnabled(true);
                }
            }
        });

        capacityField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (addressField.getText().equals("") || nameField.getText().equals("")|| capacityField.getText().equals(""))
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

    public JPanel getPanel(){ return panel1;}

    private void initSaveButton(){
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String newCarLot = addressField.getText() + " " + nameField.getText() + " has been added to the database.";
                JOptionPane.showMessageDialog(null, newCarLot);
                CarLotApi.saveCarLot(new CarLot(addressField.getText(), capacityField.getText(), nameField.getText()));
            }
        });
    }

}
