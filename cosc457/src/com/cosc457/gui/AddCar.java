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
public class AddCar extends JPanel {
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


    public AddCar(){
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
                    if (vinField.getText().equals("") || makeField.getText().equals("")||modelField.getText().equals("")|| readysaleField.getText().equals(""))
                    {
                        saveButton.setEnabled(false);
                    }
                    else
                    {
                        saveButton.setEnabled(true);
                    }
                }
            });

            makeField.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (vinField.getText().equals("") || makeField.getText().equals("")||modelField.getText().equals("") || readysaleField.getText().equals(""))
                    {
                        saveButton.setEnabled(false);
                    }
                    else
                    {
                        saveButton.setEnabled(true);
                    }
                }
            });

        modelField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (vinField.getText().equals("") || makeField.getText().equals("")|| modelField.getText().equals("") || readysaleField.getText().equals(""))
                {
                    saveButton.setEnabled(false);
                }
                else
                {
                    saveButton.setEnabled(true);
                }
            }
        });

        readysaleField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (vinField.getText().equals("") || makeField.getText().equals("")||modelField.getText().equals("") || readysaleField.getText().equals(""))
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
                    String newCar = vinField.getText() + " " + makeField.getText() + modelField.getText() + " has been added to the database.";
                    JOptionPane.showMessageDialog(null, newCar);
                    CarApi.saveCar(new Car(vinField.getText(), yearField.getText(), trimField.getText(), modelField.getText(),incolorField.getText(),excolorField.getText(), makeField.getText(), mileageField.getText(), transmissionField.getText(), drivetrainField.getText(), engineField.getText(), bodytypeField.getText(), askingField.getText(), maintenceField.getText(), datestockField.getText(), readysaleField.getText(), statusField.getText(),pspaceField.getText()));
                }
            });
        }
    }
