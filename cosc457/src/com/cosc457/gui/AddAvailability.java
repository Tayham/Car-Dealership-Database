package com.cosc457.gui;

import com.cosc457.data.AvailabilityApi;
import com.cosc457.data.SalesPeopleApi;
import com.cosc457.models.Availability;
import com.cosc457.models.SalesPeople;
import com.cosc457.util.DateUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by donnie on 11/30/16.
 */
public class AddAvailability extends JPanel {
    private JSpinner employeeSpinner;
    private JPanel panel;
    private JButton backButton;
    private JSpinner weekDaySpinner;
    private JSpinner endTimeSpinner;
    private JSpinner startTimeSpinner;
    private JButton saveAndAddAnotherButton;

    public AddAvailability(){
        setupSaveButton();
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

    private void setupSaveButton(){
        saveAndAddAnotherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int id = SalesPeopleApi.getEmployeeByName(employeeSpinner.getValue().toString()).getID();
                int weekday = DateUtil.getWeekdays().indexOf(weekDaySpinner.getValue());
                Time startTime = DateUtil.getTimeFromString(startTimeSpinner.getValue().toString());
                Time endTime = DateUtil.getTimeFromString(endTimeSpinner.getValue().toString());
                AvailabilityApi.saveAvailability(new Availability(id, weekday, startTime, endTime));
            }
        });
    }
    public void load(){
        ArrayList<String> employeeNames = new ArrayList<String>();
        for(SalesPeople e : SalesPeopleApi.getAllEmployees()){
            employeeNames.add(e.getFullName());
        }
        SpinnerListModel names = new SpinnerListModel(employeeNames);
        employeeSpinner.setModel(names);

        SpinnerListModel days = new SpinnerListModel(DateUtil.getWeekdays());
        weekDaySpinner.setModel(days);
        startTimeSpinner.setModel( new SpinnerListModel(DateUtil.getTimes()));
        endTimeSpinner.setModel( new SpinnerListModel(DateUtil.getTimes()));
    }


}
