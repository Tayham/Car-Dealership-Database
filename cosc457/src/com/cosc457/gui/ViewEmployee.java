package com.cosc457.gui;

import com.cosc457.data.SalesPeopleApi;
import com.cosc457.models.SalesPeople;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewEmployee extends JPanel{
    private JPanel panel1;
    private JButton backButton;
    private JScrollPane employees;

    public ViewEmployee(){
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
                "    <th>Salesperson ID</th>\n" +
                "    <th>First Name</th>\n" +
                "    <th>Last Name</th>\n" +
                "    <th>Salary</th>\n" +
                "    <th>Date of Birth</th>\n" +
                "    <th>Hire Date</th>\n" +
                "    <th>Phone</th>\n" +
                "    <th>Email</th>\n" +
                "  </tr>\n");
        for(SalesPeople c : SalesPeopleApi.getAllEmployees()){
            content.append("<tr>\n");
            content.append(c.toTable());
            content.append("</tr>\n");
        }
        content.append("</table>");
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        employees.getViewport().add(wrapper);
    }


}
