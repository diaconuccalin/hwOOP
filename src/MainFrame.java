import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame{
    private List ls1 = new List();
    private List ls2 = new List();
    private List ls3 = new List();
    private List ls4 = new List();

    private ErrorFrame ef = new ErrorFrame();


    public MainFrame(AllVehicles vp, AllRoutes ar, AllStops as, AllEmployees ae, Depot d1, Depot d2, Depot d3) {
        int w = 800;
        int h = 500;


        Label l1 = new Label("Vehicles", Label.CENTER);
        Label l2 = new Label("Stops", Label.CENTER);
        Label l3 = new Label("Routes", Label.CENTER);
        Label l4 = new Label("Employees", Label.CENTER);

        l1.setBounds(20, 40, 136, 20);
        l2.setBounds(176, 40, 136, 20);
        l3.setBounds(332, 40, 136, 20);
        l4.setBounds(488, 40, 136, 20);


        ls1.setBounds(20, 65, 136, 350);
        ls2.setBounds(176, 65, 136, 350);
        ls3.setBounds(332, 65, 136, 350);
        ls4.setBounds(488, 65, 136, 350);

        ls1.select(0);
        ls2.select(0);
        ls3.select(0);
        ls4.select(0);


        Label b1 = new Label("Depots");
        Button b2 = new Button(d1.getName());
        Button b3 = new Button(d2.getName());
        Button b4 = new Button(d3.getName());

        b1.setBounds(20, 460, 136, 20);
        b2.setBounds(176, 460, 136, 20);
        b3.setBounds(332, 460, 136, 20);
        b4.setBounds(488, 460, 136, 20);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepotFrame ip = new DepotFrame(d1);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepotFrame ip = new DepotFrame(d2);
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepotFrame ip = new DepotFrame(d3);
            }
        });


        Panel controlPanel = new Panel();
        controlPanel.setBackground(Color.lightGray);
        controlPanel.setBounds(644, 40, 136, 440);
        controlPanel.setLayout(null);


        Button closeButton = new Button("Close");
        closeButton.setBounds(43, 410, 50, 20);
        controlPanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        Button addVehicleButton = new Button("Add Vehicle");
        addVehicleButton.setBounds(8, 10, 120, 20);
        controlPanel.add(addVehicleButton);

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddVehicleFrame avw = new AddVehicleFrame(ls1, vp, ef);
            }
        });


        Button addRouteButton = new Button("Add Route");
        addRouteButton.setBounds(8, 35, 120, 20);
        controlPanel.add(addRouteButton);

        addRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRouteS1 ars = new AddRouteS1(ls3, ar, ef, as);
            }
        });

        Button addEmployeeButton = new Button("Add Employee");
        addEmployeeButton.setBounds(8, 60, 120, 20);
        controlPanel.add(addEmployeeButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployeeFrame aef = new AddEmployeeFrame(ls4, ae);
            }
        });


        int vn = vp.getN();
        Vehicle[] allV = vp.getPark();
        for(int i = 0; i < vn; i++) {
            ls1.add(allV[i].getType() + " - " + allV[i].getId());
        }

        int sn = as.getN();
        Stop[] allS = as.getAll();
        for(int i = 0; i < sn; i++) {
            ls2.add(allS[i].getName());
        }

        int rn = ar.getN();
        Route[] allR = ar.getAll();
        for(int i = 0; i < rn; i++) {
            ls3.add(allR[i].getId() + "");
        }

        int en = ae.getN();
        Employee[] allE = ae.getAll();
        for(int i = 0; i < en; i++) {
            ls4.add(allE[i].getName());
        }


        Button seeVehicleDetails = new Button("Vehicle Details");
        Button seeStopDetails = new Button("Stop Details");
        Button seeRouteDetails = new Button("Route Details");
        Button seeEmployeeDetails = new Button("Employee Details");

        seeVehicleDetails.setBounds(20, 420, 136, 20);
        seeStopDetails.setBounds(176, 420, 136, 20);
        seeRouteDetails.setBounds(332, 420, 136, 20);
        seeEmployeeDetails.setBounds(488, 420, 136, 20);


        seeVehicleDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedVehicle = ls1.getSelectedItem();
                    StringBuilder selVehID = new StringBuilder();

                    boolean found = false;

                    for (int i = 0; i < selectedVehicle.length(); i++) {
                        if (selectedVehicle.charAt(i) == '-') {
                            found = true;
                            i += 2;
                        }

                        if (found) {
                            selVehID.append(selectedVehicle.charAt(i));
                        }
                    }

                    Vehicle toSee = vp.findVehicle(Integer.parseInt(selVehID.toString()));
                    VehicleFrame vf = new VehicleFrame(toSee, vp, ls1);
                } catch (NullPointerException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });

        seeStopDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedStop = ls2.getSelectedItem();
                    Stop stopToSee = as.getStop(selectedStop);
                    StopFrame sf = new StopFrame(stopToSee);
                } catch (NullPointerException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });

        seeRouteDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedRoute = ls3.getSelectedItem();
                    Route routeToSee = ar.getRoute(selectedRoute);
                    RouteFrame rf = new RouteFrame(routeToSee, as, ef, ar, ls3);
                } catch(NullPointerException | NumberFormatException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });

        seeEmployeeDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedEmployee = ls4.getSelectedItem();
                    Employee employeeToSee = ae.getEmployee(selectedEmployee);
                    EmployeeFrame ef = new EmployeeFrame(employeeToSee, ls4, ae);
                } catch (NullPointerException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });


        setLayout(null);
        setSize(w, h);
        setTitle("Main Panel");
        setLocationRelativeTo(null);
        setVisible(true);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(ls1);
        add(ls2);
        add(ls3);
        add(ls4);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(controlPanel);
        add(seeVehicleDetails);
        add(seeEmployeeDetails);
        add(seeRouteDetails);
        add(seeStopDetails);
    }
}
