import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RouteFrame extends Frame{
    public RouteFrame(Route r, AllStops as, ErrorFrame ef, AllRoutes ar, List rLs, int[][] distances) {
        int w = 590;
        int h = 600;

        Color lightestGray = new Color(230, 230, 230);

        setLayout(null);
        setSize(w, h);
        setTitle("Route: " + r.getId());
        setLocationRelativeTo(null);

        Label l1 = new Label("Info", Label.CENTER);
        Label l2 = new Label("Control", Label.CENTER);
        Label l3 = new Label("Stops", Label.CENTER);

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

        int rn = r.getN();
        Stop[] s = r.getStops();
        for(int i = 0; i < rn; i++) {
            ls.add(s[i].getName());
        }

        ls.select(0);

        Label IDLabel = new Label("ID: " + r.getId(), Label.LEFT);
        p1.add(IDLabel);
        IDLabel.setBounds(2, 0, 170, 18);

        Button seeStopDetails = new Button("Stop Details");
        seeStopDetails.setBounds(400, 530, 170, 20);

        Button cancelButton = new Button("Close");
        cancelButton.setBounds(270, 560, 50, 20);

        seeStopDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedStop = ls.getSelectedItem();
                    Stop stopToSee = as.getStop(selectedStop);
                    StopFrame sf = new StopFrame(stopToSee, distances);
                } catch (NullPointerException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Button removeRoute = new Button("Remove Route");
        p2.add(removeRoute);
        removeRoute.setBounds(4, 4, 162, 20);

        removeRoute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag yes = new Flag(false);
                SureFrame sf = new SureFrame(ar, r.getId(), rLs, yes);

                sf.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {}

                    @Override
                    public void windowClosed(WindowEvent e) {
                        if(yes.getAux()) {
                            rLs.select(0);
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

        add(l1);
        add(l2);
        add(l3);
        add(p1);
        add(p2);
        add(ls);
        add(cancelButton);
        add(seeStopDetails);

        setVisible(true);
    }
}
