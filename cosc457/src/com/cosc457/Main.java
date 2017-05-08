package com.cosc457;

import com.cosc457.data.Database;
import com.cosc457.data.SalesPeopleApi;
import com.cosc457.gui.Navigation;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
        Database.getInstance().connect();
        Database.getInstance().initializeDatabase();
        SalesPeopleApi.getAllEmployees();
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Auto Express Database System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        JComponent newContentPane = Navigation.getInstance();
        newContentPane.setPreferredSize(new Dimension(640, 740));
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);


        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
