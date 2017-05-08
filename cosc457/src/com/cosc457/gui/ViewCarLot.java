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
        JPanel wrapper = new JPanel();
        StringBuilder content = new StringBuilder("<html>");
        for(CarLot c : CarLotApi.getAllCarLots()){
            content.append("<p>" + c.toString() + "</p><br>");
        }
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        carLots.getViewport().add(wrapper);
    }



}
