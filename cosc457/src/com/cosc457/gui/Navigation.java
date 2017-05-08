package com.cosc457.gui;

//import com.cosc457.ScheduleBuilder;
import com.cosc457.data.SeedData;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Navigation extends JPanel{

    JPanel navigationPanel = new JPanel();
    AddEmployee addEmployee = new AddEmployee();
    DeleteEmployee deleteEmployee = new DeleteEmployee();
    ViewEmployee viewEmployee = new ViewEmployee();
    AddCar AddCar = new AddCar();
    ViewAvailability viewAvailability = new ViewAvailability();
//    CreateSchedule createSchedule = new CreateSchedule();
    ViewSchedules viewSchedules = new ViewSchedules();

    public static Navigation INSTANCE;
    private JButton addEmployeeButton;
    private JButton deleteEmployeeButton;
    private JButton viewEmployeesButton;
    private JButton addCarButton;
    private JButton viewAvailabilityButton;
    private JButton createScheduleButton;
    private JButton viewSchedulesButton;
    private BufferedImage myPicture;

    private JButton generateSeedDataButton;

    private Navigation(){
        super(new BorderLayout());
        String imgPath = "Images/Autoexpress.PNG";
        try {
            myPicture = ImageIO.read(getClass().getResourceAsStream(imgPath));
        } catch (IOException ie)
        {
            ie.printStackTrace();
        }
        createMenu();
        add(navigationPanel);
        navigationPanel.setSize(500,500);
        initListeners();
    }

    public static Navigation getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Navigation();
        }
        return INSTANCE;
    }

    private void createMenu(){
        navigationPanel.setLayout(new MigLayout("center, wrap"));
        addEmployeeButton       = new JButton("  Add Salespeople ");
        deleteEmployeeButton    = new JButton(" Delete Salespeople");
        viewEmployeesButton     = new JButton("  View Salespeople  ");
        addCarButton   = new JButton("  Add Car  ");
        viewAvailabilityButton  = new JButton(" View Availability");
        generateSeedDataButton  = new JButton("Generate Seed Data");
        createScheduleButton    = new JButton("  Create Schedule ");
        viewSchedulesButton     = new JButton("   View Schedule  ");
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        navigationPanel.add(picLabel, "height 150, width 150");
        navigationPanel.add(addEmployeeButton, "align center, width 50:150:150");
        navigationPanel.add(deleteEmployeeButton, "align center, width 50:150:150");
        navigationPanel.add(viewEmployeesButton, "align center, width 50:150:150");
        navigationPanel.add(addCarButton, "align center, width 50:150:150");
        navigationPanel.add(viewAvailabilityButton, "align center, width 50:150:150");
        navigationPanel.add(generateSeedDataButton, "align center, width 50:150:150");
        navigationPanel.add(createScheduleButton, "align center, width 50:150:150");
        navigationPanel.add(viewSchedulesButton, "align center, width 50:150:150");
    }

    private void initListeners(){
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(addEmployee.getPanel());
                redraw();
            }
        });
        deleteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(deleteEmployee.getPanel());
                redraw();
            }
        });
        viewEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(viewEmployee.getPanel());
                viewEmployee.load();
                redraw();
            }
        });
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(AddCar.getPanel());
                redraw();
            }
        });
        viewAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(viewAvailability.getPanel());
                viewAvailability.load();
                redraw();
            }
        });
        generateSeedDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SeedData.seed();
                JLabel done = new JLabel("Done - seed data has been generated");
                navigationPanel.add(done);
            }
        });
        createScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                remove(getComponent(0));
//                add(createSchedule.getPanel());
//                createSchedule.load();
//                redraw();
            }
        });
        viewSchedulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(viewSchedules.getPanel());
                viewSchedules.load();
                redraw();
            }
        });
    }

    public void goBack(JPanel p){
       remove(p);
        add(navigationPanel);
        redraw();
    }

    public void replace(JPanel panel){
        remove(getComponent(0));
        add(panel);
        redraw();

    }

    public void redraw(){
        repaint();
        revalidate();
    }


}
