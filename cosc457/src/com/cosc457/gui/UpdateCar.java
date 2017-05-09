package com.cosc457.gui;

import com.cosc457.data.CarApi;
import com.cosc457.models.Car;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/7/2017.
 */
public class UpdateCar extends JPanel {
    private JPanel panel1;
    private JButton saveButton;
    private JButton backButton;
    private JTextField vinField;
    private JTextField yearField;
    private JTextField trimField;
    private JTextField modelField;
    private JTextField makeField;
    private JTextField mileageField;
    private JTextField transmissionField;
    private JTextField drivetrainField;
    private JTextField engineField;
    private JTextField bodytypeField;
    private JTextField askingField;
    private JTextField maintenceField;
    private JTextField datestockField;
    private JTextField readysaleField;
    private JTextField statusField;
    private JTextField pspaceField;
    private JTextField excolorField;
    private JTextField incolorField;


    public UpdateCar(){
            initSaveButton();
            saveButton.setEnabled(false);

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
                    String newCar = vinField.getText() + " " + makeField.getText() + modelField.getText() + " has been updated in the database.";
                    JOptionPane.showMessageDialog(null, newCar);
                    CarApi.updateCar(new Car(vinField.getText(), yearField.getText(), trimField.getText(), modelField.getText(),makeField.getText(), excolorField.getText(),incolorField.getText(), mileageField.getText(), transmissionField.getText(), drivetrainField.getText(), engineField.getText(), bodytypeField.getText(), askingField.getText(), maintenceField.getText(), datestockField.getText(), readysaleField.getText(), statusField.getText(),pspaceField.getText()));
                }
            });
        }
    }
