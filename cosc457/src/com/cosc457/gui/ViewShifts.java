package com.cosc457.gui;

import com.cosc457.data.ShiftApi;
import com.cosc457.models.Schedule;
import com.cosc457.models.Shift;
import com.cosc457.util.DateUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by donnie on 12/11/16.
 */
public class ViewShifts extends JPanel{
    private JButton backButton;
    private JPanel panel;
    private JScrollPane shiftList;

    private Schedule s;

    public ViewShifts(Schedule s){
        this.s = s;
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
        int weekDay = 1;
        for(Shift shift : ShiftApi.getShiftsForSchedule(s)){
            if(weekDay == shift.getWeekDay()){
                content.append("<h5>"+DateUtil.getWeekDay(weekDay)+"</h5><br>");
                weekDay++;
            }
            content.append("<p>" + shift.retrieveEmployee().getFullName() + " " + DateUtil.getPrettyTime(shift.getStartTime()) + " - "+ DateUtil.getPrettyTime(shift.getEndTime()) + "</p><br>");
        }
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        shiftList.getViewport().add(wrapper);
    }

}
