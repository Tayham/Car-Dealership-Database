package com.cosc457.gui;

//import com.cosc457.ScheduleBuilder;
import com.cosc457.data.SeedData;
import com.cosc457.models.*;
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
    UpdateEmployee UpdateEmployee = new UpdateEmployee();
    DeleteEmployee deleteEmployee = new DeleteEmployee();
    ViewEmployee viewEmployee = new ViewEmployee();

    AddCar AddCar = new AddCar();
    UpdateCar UpdateCar = new UpdateCar();
    DeleteCar DeleteCar = new DeleteCar();
    ViewCar ViewCar = new ViewCar();

    AddCarLot AddCarLot = new AddCarLot();
    UpdateCarLot UpdateCarLot = new UpdateCarLot();
    DeleteCarLot DeleteCarLot = new DeleteCarLot();
    ViewCarLot ViewCarLot = new ViewCarLot();

    AddCustomer AddCustomer = new AddCustomer();
    UpdateCustomer UpdateCustomer = new UpdateCustomer();
    DeleteCustomer DeleteCustomer = new DeleteCustomer();
    ViewCustomer ViewCustomer = new ViewCustomer();

    AddInvoice AddInvoice = new AddInvoice();
    UpdateInvoice UpdateInvoice = new UpdateInvoice();
    DeleteInvoice DeleteInvoice = new DeleteInvoice();
    ViewInvoice ViewInvoice = new ViewInvoice();

    public static Navigation INSTANCE;

    private JButton addEmployeeButton;
    private JButton UpdateEmployeeButton;

    private JButton deleteEmployeeButton;
    private JButton viewEmployeesButton;

    private JButton addCarButton;
    private JButton UpdateCarButton;
    private JButton deleteCarButton;
    private JButton viewCarButton;

    private JButton addCarLotButton;
    private JButton UpdateCarLotButton;
    private JButton deleteCarLotButton;
    private JButton viewCarLotButton;

    private JButton addCustomerButton;
    private JButton updateCustomerButton;
    private JButton deleteCustomerButton;
    private JButton viewCustomerButton;

    private JButton addInvoiceButton;
    private JButton UpdateInvoiceButton;
    private JButton deleteInvoiceButton;
    private JButton viewInvoiceButton;

    private BufferedImage myPicture;

    private JLabel SalesPeopleLabel;
    private JLabel CarLabel;
    private JLabel CustomerLabel;
    private JLabel CarLotLabel;
    private JLabel InvoiceLabel;

//    private JButton generateSeedDataButton;

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

        SalesPeopleLabel = new JLabel("SalesPeople Options",JLabel.CENTER);
        addEmployeeButton       = new JButton("  Add Salespeople ");
        UpdateEmployeeButton       = new JButton("  Update Salespeople ");
        deleteEmployeeButton    = new JButton(" Delete Salespeople");
        viewEmployeesButton     = new JButton("  View Salespeople  ");

        CarLabel = new JLabel("Car Options",JLabel.CENTER);
        addCarButton   = new JButton("  Add Car  ");
        UpdateCarButton   = new JButton("  Update Car  ");
        deleteCarButton = new JButton(" Delete Car");
        viewCarButton = new JButton("  View Cars ");

        CarLotLabel = new JLabel("Car Lot Options",JLabel.CENTER);
        addCarLotButton   = new JButton("  Add CarLot  ");
        UpdateCarLotButton   = new JButton("  Update CarLot  ");

        deleteCarLotButton = new JButton(" Delete CarLot");
        viewCarLotButton = new JButton("  View CarLots ");

        CustomerLabel = new JLabel("Customer Options",JLabel.CENTER);
        addCustomerButton   = new JButton("  Add Customer  ");
        updateCustomerButton   = new JButton("  Update Customer  ");
        deleteCustomerButton = new JButton(" Delete Customer");
        viewCustomerButton = new JButton("  View Customers ");


        InvoiceLabel = new JLabel("Invoice Options",JLabel.CENTER);
        addInvoiceButton   = new JButton("  Add Invoice  ");
        UpdateInvoiceButton   = new JButton("  Update Invoice  ");

        deleteInvoiceButton = new JButton(" Delete Invoice");
        viewInvoiceButton = new JButton("  View Invoices ");
;
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        navigationPanel.add(picLabel, "height 150, width 150");

        navigationPanel.add(SalesPeopleLabel, "align center, width 50:150:150, height 50");
        navigationPanel.add(addEmployeeButton, "align center, width 50:150:150");
        navigationPanel.add(UpdateEmployeeButton, "align center, width 50:150:150");

        navigationPanel.add(deleteEmployeeButton, "align center, width 50:150:150");
        navigationPanel.add(viewEmployeesButton, "align center, width 50:150:150");

        navigationPanel.add(CarLabel, "align center, width 50:150:150, height 50");
        navigationPanel.add(addCarButton, "align center, width 50:150:150");
        navigationPanel.add(UpdateCarButton, "align center, width 50:150:150");

        navigationPanel.add(deleteCarButton, "align center, width 50:150:150");
        navigationPanel.add(viewCarButton, "align center, width 50:150:150");

        navigationPanel.add(CarLotLabel, "align center, width 50:150:150, height 50");
        navigationPanel.add(addCarLotButton, "align center, width 50:150:150");
        navigationPanel.add(UpdateCarLotButton, "align center, width 50:150:150");

        navigationPanel.add(deleteCarLotButton, "align center, width 50:150:150");
        navigationPanel.add(viewCarLotButton, "align center, width 50:150:150");

        navigationPanel.add(CustomerLabel, "align center, width 50:150:150, height 50");
        navigationPanel.add(addCustomerButton, "align center, width 50:150:150");
        navigationPanel.add(updateCustomerButton, "align center, width 50:150:150");
        navigationPanel.add(deleteCustomerButton, "align center, width 50:150:150");
        navigationPanel.add(viewCustomerButton, "align center, width 50:150:150");

        navigationPanel.add(InvoiceLabel, "align center, width 50:150:150, height 50");
        navigationPanel.add(addInvoiceButton, "align center, width 50:150:150");
        navigationPanel.add(UpdateInvoiceButton, "align center, width 50:150:150");
        navigationPanel.add(deleteInvoiceButton, "align center, width 50:150:150");
        navigationPanel.add(viewInvoiceButton, "align center, width 50:150:150");

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

        UpdateEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(UpdateEmployee.getPanel());
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

        UpdateCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(UpdateCar.getPanel());
                redraw();
            }
        });

        deleteCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(DeleteCar.getPanel());
                redraw();
            }
        });

        viewCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(ViewCar.getPanel());
                ViewCar.load();
                redraw();
            }
        });

        addCarLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(AddCarLot.getPanel());
                redraw();
            }
        });

        UpdateCarLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(UpdateCarLot.getPanel());
                redraw();
            }
        });

        deleteCarLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(DeleteCarLot.getPanel());
                redraw();
            }
        });

        viewCarLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(ViewCarLot.getPanel());
                ViewCarLot.load();
                redraw();
            }
        });

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(AddCustomer.getPanel());
                redraw();
            }
        });

        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(UpdateCustomer.getPanel());
                redraw();
            }
        });

        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(DeleteCustomer.getPanel());
                redraw();
            }
        });

        viewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(ViewCustomer.getPanel());
                ViewCustomer.load();
                redraw();
            }
        });

        addInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(AddInvoice.getPanel());
                redraw();
            }
        });

        UpdateInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(UpdateInvoice.getPanel());
                redraw();
            }
        });

        deleteInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(DeleteInvoice.getPanel());
                redraw();
            }
        });

        viewInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(ViewInvoice.getPanel());
                ViewInvoice.load();
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
