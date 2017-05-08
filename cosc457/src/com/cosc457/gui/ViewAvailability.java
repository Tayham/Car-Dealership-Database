package com.cosc457.gui;

import com.cosc457.data.AvailabilityApi;
import com.cosc457.data.SalesPeopleApi;
import com.cosc457.models.Availability;
import com.cosc457.models.SalesPeople;
import com.cosc457.util.DateUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.HashMap;

/**
 * Created by donnie on 12/5/16.
 */
public class ViewAvailability extends JPanel{
    private JPanel panel;
    private JButton backButton;
    private JScrollPane scrollPane;

    public ViewAvailability(){
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
        StringBuilder content = new StringBuilder("<html>");
        HashMap<Integer, SalesPeople> emps = SalesPeopleApi.getEmployeeIdMap();
        StringBuilder monday = new StringBuilder("Monday<br>");
        StringBuilder tuesday = new StringBuilder("<br>Tuesday</br>");
        StringBuilder wednesday = new StringBuilder("<br>Wednesday</br>");
        StringBuilder thursday = new StringBuilder("<br>Thursday</br>");
        StringBuilder friday = new StringBuilder("<br>Friday</br>");
        for(Availability a : AvailabilityApi.getAllAvailabilities()){
           if(a.getWeekDay() == DayOfWeek.MONDAY.getValue()){
               monday.append("<p>"+emps.get(a.getEmployeeID()).getFullName() + " " + DateUtil.getPrettyTime(a.getStartTime()) + " - " + DateUtil.getPrettyTime(a.getEndTime()) + "</p><br>");
           }else if(a.getWeekDay() == DayOfWeek.TUESDAY.getValue()){
               tuesday.append("<p>" + emps.get(a.getEmployeeID()).getFullName() + " " + DateUtil.getPrettyTime(a.getStartTime()) + " - " + DateUtil.getPrettyTime(a.getEndTime()) + "</p><br>");
           }else if(a.getWeekDay() == DayOfWeek.WEDNESDAY.getValue()){
               wednesday.append("<p>" + emps.get(a.getEmployeeID()).getFullName() + " " + DateUtil.getPrettyTime(a.getStartTime()) + " - " + DateUtil.getPrettyTime(a.getEndTime()) + "</p><br>");
           }else if(a.getWeekDay() == DayOfWeek.THURSDAY.getValue()){
               thursday.append("<p>" + emps.get(a.getEmployeeID()).getFullName() + " " + DateUtil.getPrettyTime(a.getStartTime()) + " - " + DateUtil.getPrettyTime(a.getEndTime()) + "</p><br>");
           }else if(a.getWeekDay() == DayOfWeek.FRIDAY.getValue()){
               friday.append("<p>" + emps.get(a.getEmployeeID()).getFullName() + " " + DateUtil.getPrettyTime(a.getStartTime()) + " - " + DateUtil.getPrettyTime(a.getEndTime()) + "</p><br>");
           }
        }
        content.append(monday.toString() + tuesday.toString() + wednesday.toString() + thursday.toString() + friday.toString());
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        scrollPane.getViewport().add(wrapper);
    }
    public void buildScroll(){

    }

}
