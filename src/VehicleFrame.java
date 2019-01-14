import java.awt.*;
import java.awt.event.*;

public class VehicleFrame extends Frame {
    public VehicleFrame(Vehicle v, AllVehicles av, List ls, AllRoutes ar) {
        int w = 400;
        int h = 600;

        setLayout(null);
        setSize(w, h);
        setTitle("Vehicle: " + v.getId());
        setLocationRelativeTo(null);
        setVisible(true);


        Label l1 = new Label("Info", Label.CENTER);
        Label l2 = new Label("Control", Label.CENTER);

        l1.setBounds(20, 40, 170, 20);
        l2.setBounds(210, 40, 170, 20);


        Panel p1 = new Panel();
        Panel p2 = new Panel();

        Color lightestGray = new Color(230, 230, 230);

        p1.setBackground(lightestGray);
        p2.setBackground(lightestGray);

        p1.setBounds(20, 70, 170, 480);
        p2.setBounds(210, 70, 170, 480);

        p1.setLayout(null);
        p2.setLayout(null);

        Label typeLabel = new Label("Type: " + v.getType(), Label.LEFT);
        p1.add(typeLabel);
        typeLabel.setBounds(2, 0, 170, 18);

        Label idLabel = new Label("ID: " + v.getId(), Label.LEFT);
        p1.add(idLabel);
        idLabel.setBounds(2, 15, 170, 18);

        Label fuelLabel = new Label("Fuel: " + v.getFuel(), Label.LEFT);
        p1.add(fuelLabel);
        fuelLabel.setBounds(2, 30, 170, 18);

        Label malfunctionLabel = new Label("Malfunction: " + (v.isMalfunction() ? "YES" : "NO"));
        p1.add(malfunctionLabel);
        malfunctionLabel.setBounds(2, 45, 170, 18);


        Button removeVehicle = new Button("Remove Vehicle");
        p2.add(removeVehicle);
        removeVehicle.setBounds(4, 28, 162, 20);

        removeVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag yes = new Flag(false);
                SureFrame sf = new SureFrame(av, v.getId(), ls, yes);

                sf.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {}

                    @Override
                    public void windowClosed(WindowEvent e) {
                        if(yes.getAux()) {
                            ls.select(0);
                            dispose();
                        }
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {}

                    @Override
                    public void windowIconified(WindowEvent e) {}

                    @Override
                    public void windowDeiconified(WindowEvent e) {}

                    @Override
                    public void windowActivated(WindowEvent e) {}

                    @Override
                    public void windowDeactivated(WindowEvent e) {}
                });
            }
        });

        Button sendOnRoute = new Button("Send on route");
        p2.add(sendOnRoute);
        sendOnRoute.setBounds(4, 4, 162, 20);

        sendOnRoute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag yes = new Flag(false);

                ChooseRouteFrame crf = new ChooseRouteFrame(ar, v);

//                Flag yes = new Flag(false);
//                SureFrame sf = new SureFrame(av, v.getId(), ls, yes);
//
//                sf.addWindowListener(new WindowListener() {
//                    @Override
//                    public void windowOpened(WindowEvent e) {}
//
//                    @Override
//                    public void windowClosed(WindowEvent e) {
//                        if(yes.getAux()) {
//                            ls.select(0);
//                            dispose();
//                        }
//                    }
//
//                    @Override
//                    public void windowClosing(WindowEvent e) {}
//
//                    @Override
//                    public void windowIconified(WindowEvent e) {}
//
//                    @Override
//                    public void windowDeiconified(WindowEvent e) {}
//
//                    @Override
//                    public void windowActivated(WindowEvent e) {}
//
//                    @Override
//                    public void windowDeactivated(WindowEvent e) {}
//                });
            }
        });

        Button cancelButton = new Button("Close");
        cancelButton.setBounds(175, 560, 50, 20);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        add(l1);
        add(l2);
        add(p1);
        add(p2);
        add(cancelButton);
    }
}
