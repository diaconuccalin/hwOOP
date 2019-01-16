import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepotFrame extends Frame{
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
