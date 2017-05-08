package com.cosc457.gui;

import com.cosc457.data.CarApi;
import com.cosc457.data.SalesPeopleApi;
import com.cosc457.models.Car;
import com.cosc457.models.SalesPeople;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/7/2017.
 */
public class DeleteCar extends JPanel {
    private JPanel panel1;
    private JTextField vinField;
    private JButton deleteButton;
    private JButton backButton;

    public DeleteCar(){
        initDeleteButton();
        deleteButton.setEnabled(false);

        vinField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (vinField.getText().equals(""))
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
                String carDeleted = vinField.getText() + " has been removed from the database.";
                JOptionPane.showMessageDialog(null, carDeleted);
                CarApi.deleteCar(new Car(vinField.getText()));
            }
        });
    }
}
