package com.cosc457.gui;

import com.cosc457.data.CarLotApi;
import com.cosc457.models.CarLot;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/7/2017.
 */
public class UpdateCarLot extends JPanel {
    private JPanel panel1;
    private JButton saveButton;
    private JButton backButton;
    private JTextField addressField;
    private JTextField capacityField;
    private JTextField nameField;



    public UpdateCarLot(){
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
                if (addressField.getText().equals(""))
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
                String newCarLot = addressField.getText() + " " + nameField.getText() + " has been updated in the database.";
                JOptionPane.showMessageDialog(null, newCarLot);
                CarLotApi.updateCarLot(new CarLot(addressField.getText(), capacityField.getText(), nameField.getText()));
            }
        });
    }

}
