package com.cosc457.gui;

import com.cosc457.data.CustomerApi;
import com.cosc457.models.Customer;
import com.cosc457.models.SalesPeople;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/8/2017.
 */
public class ViewCustomer extends JPanel {
    private JPanel panel1;
    private JButton backButton;
    private JScrollPane customers;

    public ViewCustomer(){
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
                "    <th>Customer SSN</th>\n" +
                "    <th>First Name</th>\n" +
                "    <th>Last Name</th>\n" +
                "    <th>Phone</th>\n" +
                "    <th>Email</th>\n" +
                "  </tr>\n");
        for(Customer c : CustomerApi.getAllCustomers()){
            content.append("<tr>\n");
            content.append(c.toTable());
            content.append("</tr>\n");
        }
        content.append("</table>");
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        customers.getViewport().add(wrapper);
    }

}
