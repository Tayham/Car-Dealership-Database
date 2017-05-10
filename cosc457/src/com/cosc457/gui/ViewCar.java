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

        content.append("<table>\n" +
                "  <tr>\n" +
                "    <th>VIN</th>\n" +
                "    <th>Year</th>\n" +
                "    <th>Trim</th>\n" +
                "    <th>Model</th>\n" +
                "    <th>Make</th>\n" +
                "    <th>Exterior Color</th>\n" +
                "    <th>Interior Color</th>\n" +
                "    <th>Mileage</th>\n" +
                "    <th>Transmission</th>\n" +
                "    <th>Drive Train</th>\n" +
                "    <th>Engine</th>\n" +
                "    <th>Body Type</th>\n" +
                "    <th>Asking Price</th>\n" +
                "    <th>Maintenance</th>\n" +
                "    <th>Date Stock</th>\n" +
                "    <th>Ready for Sale</th>\n" +
                "    <th>Status</th>\n" +
                "    <th>Parking Space</th>\n" +
                "  </tr>\n");
        for(Car c : CarApi.getAllCars()){
            content.append("<tr>\n");
            content.append(c.toTable());
            content.append("</tr>\n");
        }
        content.append("</table>");
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        cars.getViewport().add(wrapper);
    }




}
