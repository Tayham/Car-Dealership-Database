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
public class DeleteInvoice extends JPanel{
    private JPanel panel1;
    private JTextField idField;
    private JButton deleteButton;
    private JButton backButton;

    public DeleteInvoice(){
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

                String InvoiceDeleted = idField.getText() + " has been removed from the database.";
                JOptionPane.showMessageDialog(null, InvoiceDeleted);
                InvoiceApi.deleteInvoice(new Invoice(idInt));
            }
        });
    }

}
