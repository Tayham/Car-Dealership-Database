package com.cosc457.gui;

import com.cosc457.data.CarApi;
import com.cosc457.data.SalesPeopleApi;
import com.cosc457.models.Car;
import com.cosc457.models.SalesPeople;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/7/2017.
 */
public class ViewCar {
    private JPanel panel1;
    private JButton backButton;
    private JScrollPane cars;

    public ViewCar(){
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
        for(Car c : CarApi.getAllCars()){
            content.append("<p>" + c.toString() + "</p><br>");
        }
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        cars.getViewport().add(wrapper);
    }



}
