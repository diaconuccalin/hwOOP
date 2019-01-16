/**
 * <h1>Depot frame</h1>
 * The DepotFrame class is the window which gives access to information about the Depot and list of stored Vehicles.
 * <br>It creates a 590x600 window, which shows a panel with information and a List with all the Vehicles available.
 * It will also have a button to obtain more information about the selected Vehicle.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepotFrame extends Frame{
    /**
     * Constructor method.
     * @param dep This is the Depot of interest.
     * @param ef This is used when trying to get the details of a Vehicle when nothing in the List is selected.
     * @param distances The matrix of distances between all the Places.
     * @param ar The list of all Routes, passed to VehicleFrame.
     * @param ae The list of all Employees, passed to VehicleFrame.
     * @param d1 The first depot.
     * @param d2 The second depot.
     * @param d3 The third depot.
     */
    public DepotFrame(Depot dep, ErrorFrame ef, int[][] distances, AllRoutes ar, AllEmployees ae, Depot d1, Depot d2, Depot d3) {
        int w = 590;
        int h = 600;

        Color lightestGray = new Color(230, 230, 230);

        setLayout(null);
        setSize(w, h);
        setTitle("Depot: " + dep.getName());
        setLocationRelativeTo(null);

        Label l1 = new Label("Info", Label.CENTER);
        Label l2 = new Label("Control", Label.CENTER);
        Label l3 = new Label("Vehicles", Label.CENTER);

        l1.setBounds(20, 40, 170, 20);
        l2.setBounds(210, 40, 170, 20);
        l3.setBounds(400, 40, 170, 20);

        Panel p1 = new Panel();
        Panel p2 = new Panel();
        List ls = new List();

        p1.setBounds(20, 70, 170, 480);
        p2.setBounds(210, 70, 170, 480);
        ls.setBounds(400, 70, 170, 450);

        p1.setBackground(lightestGray);
        p2.setBackground(lightestGray);

        p1.setLayout(null);
        p2.setLayout(null);

        int vn = dep.getAvd().getN();
        Vehicle[] v = dep.getAvd().getPark();
        for(int i = 0; i < vn; i++) {
            ls.add(v[i].getType() + " - " + v[i].getId());
        }
        ls.select(0);

        Label nameLabel = new Label("Name: " + dep.getName(), Label.LEFT);
        p1.add(nameLabel);
        nameLabel.setBounds(2, 0, 170, 18);

        Label idLabel = new Label("ID: " + dep.getId(), Label.LEFT);
        p1.add(idLabel);
        idLabel.setBounds(2, 15, 170, 18);

        Button cancelButton = new Button("Close");
        Button seeVehicleDetails = new Button("Vehicle");

        cancelButton.setBounds(270, 560, 50, 20);
        seeVehicleDetails.setBounds(400, 530, 170, 20);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        seeVehicleDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedVehicle = ls.getSelectedItem();
                    Vehicle vToSee = dep.getAvd().getVehicle(selectedVehicle);
                    VehicleFrame vf = new VehicleFrame(vToSee, dep.getAvd(), ls, ar, ae, distances, d1, d2, d3);
                } catch (NullPointerException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });

        add(l1);
        add(l2);
        add(l3);
        add(p1);
        add(p2);
        add(ls);
        add(cancelButton);
        add(seeVehicleDetails);

        setVisible(true);
    }
}
