package com.cosc457.gui;

import com.cosc457.data.InvoiceApi;
import com.cosc457.models.Invoice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/8/2017.
 */
public class ViewInvoice extends JPanel {
    private JPanel panel1;
    private JButton backButton;
    private JScrollPane invoices;

    public ViewInvoice(){
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

    public void load(){
        JPanel wrapper = new JPanel();
        StringBuilder content = new StringBuilder("<html>");

        content.append("<table>\n" +
                "  <tr>\n" +
                "    <th>Invoice ID</th>\n" +
                "    <th>Buy Price</th>\n" +
                "    <th>Sell Price</th>\n" +
                "    <th>Date</th>\n" +
                "    <th>Signature</th>\n" +
                "    <th>Salesperson ID</th>\n" +
                "    <th>Customer SSN</th>\n" +
                "    <th>Vehicle VIN</th>\n" +
                "  </tr>\n");
        for(Invoice c : InvoiceApi.getAllInvoices()){
            content.append("<tr>\n");
            content.append(c.toTable());
            content.append("</tr>\n");
        }
        content.append("</table>");
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        invoices.getViewport().add(wrapper);
    }

}
