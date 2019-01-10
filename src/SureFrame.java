import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SureFrame extends Frame {
    public SureFrame(AllVehicles av, int vId, List ls, Flag yes) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setLocationRelativeTo(null);
        setVisible(true);

        Label l = new Label("Are you sure you want to remove this?", Label.CENTER);
        Button yButton = new Button("Yes");
        Button nButton = new Button("No");

        l.setBounds(10, 30, 230, 60);
        yButton.setBounds(75, 100, 40, 22);
        nButton.setBounds(125, 100, 40, 22);

        add(l);
        add(yButton);
        add(nButton);

        yButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                av.removeVehicle(vId);
                ls.remove(ls.getSelectedItem());
                yes.setAux(true);
                dispose();
            }
        });

        nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public SureFrame(AllEmployees ae, String eName, List ls, Flag yes) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setLocationRelativeTo(null);
        setVisible(true);

        Label l = new Label("Are you sure you want to remove this?", Label.CENTER);
        Button yButton = new Button("Yes");
        Button nButton = new Button("No");

        l.setBounds(10, 30, 230, 60);
        yButton.setBounds(75, 100, 40, 22);
        nButton.setBounds(125, 100, 40, 22);

        add(l);
        add(yButton);
        add(nButton);

        yButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ae.removeEmployee(eName);
                ls.remove(ls.getSelectedItem());
                yes.setAux(true);
                dispose();
            }
        });

        nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public SureFrame(AllRoutes ar, int routeID, List ls, Flag yes) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setLocationRelativeTo(null);
        setVisible(true);

        Label l = new Label("Are you sure you want to remove this?", Label.CENTER);
        Button yButton = new Button("Yes");
        Button nButton = new Button("No");

        l.setBounds(10, 30, 230, 60);
        yButton.setBounds(75, 100, 40, 22);
        nButton.setBounds(125, 100, 40, 22);

        add(l);
        add(yButton);
        add(nButton);

        yButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ar.removeRoute(routeID);
                ls.remove(ls.getSelectedItem());
                yes.setAux(true);
                dispose();
            }
        });

        nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
