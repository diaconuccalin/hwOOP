/**
 * <h1>Employee frame</h1>
 * The EmployeeFrame class is the window which gives access to information and control
 * on a certain Employee.
 * <br>It creates a 590x600 window, which shows a panel with information and another panel with buttons that
 * enables the user to give orders or remove the Employee.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EmployeeFrame extends Frame {
    /**
     * Constructor function.
     * @param e This is the Employee of interest.
     * @param ls The List from which the Employee should be removed if this option is selected.
     * @param ae The AllEmployees object from which the Employee should be removed if this option is selected.
     */
    public EmployeeFrame(Employee e, List ls, AllEmployees ae) {
        int w = 400;
        int h = 600;

        Color lightestGray = new Color(230, 230, 230);

        setLayout(null);
        setSize(w, h);
        setTitle("Employee: " + e.getName());
        setLocationRelativeTo(null);

        Label l1 = new Label("Info", Label.CENTER);
        Label l2 = new Label("Control", Label.CENTER);

        l1.setBounds(20, 40, 170, 20);
        l2.setBounds(210, 40, 170, 20);

        Panel p1 = new Panel();
        Panel p2 = new Panel();

        p1.setBounds(20, 70, 170, 480);
        p2.setBounds(210, 70, 170, 480);

        p1.setBackground(lightestGray);
        p2.setBackground(lightestGray);

        p1.setLayout(null);
        p2.setLayout(null);

        Label nameLabel = new Label("Name: " + e.getName(), Label.LEFT);
        nameLabel.setBounds(2, 0, 170, 18);
        p1.add(nameLabel);

        Label onRoadLabel = new Label();
        onRoadLabel.setBounds(2, 15, 170, 18);
        p1.add(onRoadLabel);
        if(e.isOnRoad()) {
            onRoadLabel.setText("Active: YES");

            Label vehicleLabel = new Label("Current vehicle: " + e.getVehicle().getType() + " - " + e.getVehicle().getId());
            vehicleLabel.setBounds(2, 30, 170, 18);
            p1.add(vehicleLabel);

            Label timeLabel = new Label("Active time: " + (160 - e.getActiveTime()));
            timeLabel.setBounds(2, 45, 170, 18);
            p1.add(timeLabel);
        }else {
            onRoadLabel.setText("Active: NO");
        }

        Button cancelButton = new Button("Close");
        cancelButton.setBounds(175, 560, 50, 20);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Button removeEmployee = new Button("Remove Employee");
        p2.add(removeEmployee);
        removeEmployee.setBounds(4, 4, 162, 20);

        removeEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ace) {
                Flag yes = new Flag(false);
                SureFrame sf = new SureFrame(ae, e.getName(), ls, yes);

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

        add(l1);
        add(l2);
        add(p1);
        add(p2);
        add(cancelButton);

        setVisible(true);
    }
}
