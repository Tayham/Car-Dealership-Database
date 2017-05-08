package com.cosc457.gui;

import com.cosc457.data.CarLotApi;
import com.cosc457.models.CarLot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taylor on 5/7/2017.
 */
public class ViewCarLot {
    private JPanel panel1;
    private JButton backButton;
    private JScrollPane carLots;

    //If results not showing up add the object type in the database class
    public ViewCarLot(){
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
        System.out.println("loaded");
        JPanel wrapper = new JPanel();
        StringBuilder content = new StringBuilder("<html>");
        for(CarLot lot : CarLotApi.getAllCarLots()){
            content.append("<p>" + lot.toString() + "</p><br>");
            System.out.println(lot.toString());
        }
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        carLots.getViewport().add(wrapper);
    }



}
