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
        for(SalesPeople s : SalesPeopleApi.getAllEmployees()){
            content.append("<p>" + s.toString() + "</p><br>");
        }
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        employees.getViewport().add(wrapper);
    }



}
