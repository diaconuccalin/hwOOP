import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseDestinationFrame extends Frame {
    public ChooseDestinationFrame(AllRoutes ar, Vehicle v, AllEmployees ae, int[][] distances) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Choose Route");
        setLocationRelativeTo(null);

        Label l = new Label("Choose the route to designate:", Label.CENTER);
        Choice routes = new Choice();

        l.setBounds(10, 35, 230, 30);
        routes.setBounds(75, 65, 100, 60);

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");

        okButton.setBounds(67, 100, 50, 22);
        cancelButton.setBounds(133, 100, 50, 22);

        for(int i = 0; i < ar.getN(); i++) {
            routes.add(ar.getAll()[i].getId() + "");
        }

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.sendOnRoute(ar.getRoute(routes.getSelectedItem()), ae, distances);
                if(v.getCurrentDepot() != null) {
                    v.getCurrentDepot().removeVehicle(v);
                }
                v.setCurrentDepot(null);
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(l);
        add(routes);
        add(okButton);
        add(cancelButton);

        setVisible(true);
    }

    public ChooseDestinationFrame(Depot d1, Depot d2, Depot d3, Vehicle v, AllEmployees ae, int[][] distances) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Choose Depot");
        setLocationRelativeTo(null);

        Label l = new Label("Choose the depot to send to:", Label.CENTER);
        Choice depots = new Choice();

        l.setBounds(10, 35, 230, 30);
        depots.setBounds(75, 65, 100, 60);

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");

        okButton.setBounds(67, 100, 50, 22);
        cancelButton.setBounds(133, 100, 50, 22);

        depots.add("Bucium");
        depots.add("Unirii");
        depots.add("Zorilor");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(v.getCurrentDepot() != null) {
                    v.getCurrentDepot().removeVehicle(v);
                }

                switch (depots.getSelectedItem()) {
                    case "Bucium" : d1.addVehicle(v);
                                    v.setCurrentDepot(d1);
                                    break;
                    case "Unirii" : d2.addVehicle(v);
                                    v.setCurrentDepot(d2);
                                    break;
                    case "Zorilor": d3.addVehicle(v);
                                    v.setCurrentDepot(d3);
                                    break;
                }

                v.getActiveRoute().removeVehicle(v);
                v.setActiveRoute(null);

                if(v.getDriver() != null) {
                    v.getDriver().setOnRoad(false);
                    v.getDriver().setVehicle(null);
                }

                v.removeDriver();

                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(l);
        add(depots);
        add(okButton);
        add(cancelButton);

        setVisible(true);
    }
}
