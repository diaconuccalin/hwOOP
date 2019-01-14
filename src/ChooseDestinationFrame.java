import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseDestinationFrame extends Frame {
    public ChooseDestinationFrame(AllRoutes ar, Vehicle v, AllEmployees ae, int[][] distances) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setLocationRelativeTo(null);
        setVisible(true);

        Label l = new Label("Choose the route to designate:", Label.CENTER);
        Choice routes = new Choice();
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");

        l.setBounds(10, 35, 230, 30);
        routes.setBounds(75, 65, 100, 60);
        okButton.setBounds(67, 100, 50, 22);
        cancelButton.setBounds(133, 100, 50, 22);

        add(l);
        add(routes);
        add(okButton);
        add(cancelButton);

        for(int i = 0; i < ar.getN(); i++) {
            routes.add(ar.getAll()[i].getId() + "");
        }

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

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
    }
}
