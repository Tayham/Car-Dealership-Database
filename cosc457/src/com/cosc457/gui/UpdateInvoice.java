package com.cosc457.gui;

import com.cosc457.data.InvoiceApi;
import com.cosc457.models.Invoice;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/8/2017.
 */
public class UpdateInvoice extends JPanel {
    private JPanel panel1;
    private JTextField buyField;
    private JTextField sellField;
    private JTextField saleIDField;
    private JButton saveButton;
    private JButton backButton;
    private JTextField sigField;
    private JTextField dateField;
    private JTextField custSSNField;
    private JTextField carVINField;
    private JTextField idField;


    public UpdateInvoice(){
        initSaveButton();
        saveButton.setEnabled(false);

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
                String newInvoiceCreated = "If the info is correct the invoice has been updated in the database.";
                JOptionPane.showMessageDialog(null, newInvoiceCreated);
                InvoiceApi.updateInvoice(new Invoice(Integer.parseInt(idField.getText()), buyField.getText(), sellField.getText(), dateField.getText(), sigField.getText(), Integer.parseInt(saleIDField.getText()), custSSNField.getText(), carVINField.getText()));
            }
        });
    }
}
