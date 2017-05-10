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
        JPanel wrapper = new JPanel();
        StringBuilder content = new StringBuilder("<html>");

        content.append("<table>\n" +
                "  <tr>\n" +
                "    <th>Address</th>\n" +
                "    <th>Capacity</th>\n" +
                "    <th>Name</th>\n" +
                "  </tr>\n");
        for(CarLot c : CarLotApi.getAllCarLots()){
            content.append("<tr>\n");
            content.append(c.toTable());
            content.append("</tr>\n");
        }
        content.append("</table>");
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        carLots.getViewport().add(wrapper);
    }



}
