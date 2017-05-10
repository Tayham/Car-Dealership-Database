package com.cosc457.gui;

import com.cosc457.data.SalesPeopleApi;
import com.cosc457.models.SalesPeople;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


 // Created by David on 12/11/2016.


public class DeleteEmployee extends JPanel {
    private JPanel panel1;
    private JTextField idField;
    private JButton deleteButton;
    private JButton backButton;

    public DeleteEmployee(){
        initDeleteButton();
        deleteButton.setEnabled(false);

        idField.getDocument().addDocumentListener(new DocumentListener() {
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
                if (idField.getText().equals(""))
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
                int idInt = Integer.parseInt(idField.getText());
                String employeeDeleted = idField.getText() + " has been removed from the database.";
                JOptionPane.showMessageDialog(null, employeeDeleted);
                SalesPeopleApi.deleteSalesPeople(new SalesPeople(idInt));
            }
        });
    }
}
