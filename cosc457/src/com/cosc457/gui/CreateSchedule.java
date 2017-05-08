//package com.cosc457.gui;
//
//import com.cosc457.ScheduleBuilder;
//import com.cosc457.data.SalesPeopleApi;
//import com.cosc457.models.SalesPeople;
//import com.cosc457.util.DateUtil;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Date;
//
///**
// * Created by donnie on 12/11/16.
// */
//public class CreateSchedule extends JPanel{
//    private JPanel panel;
//    private JButton backButton;
//    private JSpinner startDateSpinner;
//    private JButton createScheduleButton;
//    private JSpinner endDateSpinner;
//    private JProgressBar progressBar;
//
//    public CreateSchedule(){
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                Navigation.getInstance().goBack(panel);
//            }
//        });
//    }
//
//    public JPanel getPanel(){
//        return panel;
//    }
//
//    public void load(){
//        ArrayList<String> employeeNames = new ArrayList<String>();
//        for(SalesPeople e : SalesPeopleApi.getAllEmployees()){
//            employeeNames.add(e.getFullName());
//        }
//        ArrayList<java.sql.Date> dates = DateUtil.getFutureDates();
//        SpinnerListModel days = new SpinnerListModel(dates);
//        startDateSpinner.setModel(days);
//        SpinnerListModel endDays = new SpinnerListModel(dates);
//        endDateSpinner.setModel(endDays);
//
//        createScheduleButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                Thread t = new Thread(new Runnable() {
//                    public void run()
//                    {
//                        new ScheduleBuilder((Date)startDateSpinner.getValue(), (Date)endDateSpinner.getValue(), progressBar).build();
//                    }
//                });
//                t.start();
//
//            }
//        });
//    }
//
//}
