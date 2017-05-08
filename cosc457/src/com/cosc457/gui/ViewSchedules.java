package com.cosc457.gui;


import com.cosc457.data.ScheduleApi;
import com.cosc457.models.Schedule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by donnie on 12/11/16.
 */
public class ViewSchedules extends JPanel {
    private JPanel panel;
    private JButton backButton;
    private JScrollPane list;


    public ViewSchedules(){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Navigation.getInstance().goBack(panel);
            }
        });
    }

    public JPanel getPanel(){
        return panel;
    }

    public void load(){
        JPanel wrapper = new JPanel();
        for(final Schedule s : ScheduleApi.getAllSchedules()){
            JButton b = new JButton(s.toString());
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    ViewShifts viewShifts = new ViewShifts(s);
                    Navigation.getInstance().replace(viewShifts.getPanel());
                    viewShifts.load();
                }
            });
            wrapper.add(b);
        }
        list.getViewport().add(wrapper);

    }

}

