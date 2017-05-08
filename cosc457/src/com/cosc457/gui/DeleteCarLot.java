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
public class DeleteCarLot extends JPanel {
    private JPanel panel1;
    private JTextField addressField;
    private JButton deleteButton;
    private JButton backButton;

    public DeleteCarLot(){
        initDeleteButton();
        deleteButton.setEnabled(false);

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
                String carLotDeleted = addressField.getText() + " has been removed from the database.";
                JOptionPane.showMessageDialog(null, carLotDeleted);
                CarLotApi.deleteCarLot(new CarLot(addressField.getText()));
            }
        });
    }
}
