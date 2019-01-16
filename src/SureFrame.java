/**
 * <h1>Sure frame</h1>
 * A window used to recheck the decision of the user to delete a certain Object.
 * <br>It creates a 250x150 window with a text and two buttons, Yes, which executes the deletion, and No,
 * which cancels the action.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SureFrame extends Frame {
    /**
     * Constructor method for when the user removes a Vehicle.
     * @param av The list of all the Vehicles.
     * @param vId The id of the Vehicle to be removed.
     * @param ls The List from which the Vehicle needs to be removed.
     * @param yes A flag which lets the caller method know what choice has been made by the user.
     */
    public SureFrame(AllVehicles av, int vId, List ls, Flag yes) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setLocationRelativeTo(null);

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

        setVisible(true);
    }

    /**
     * Constructor method for when the user removes an Employee.
     * @param ae The list of all Employees.
     * @param eName The name of the Employee to be removed.
     * @param ls The List from which the Employee needs to be removed.
     * @param yes A flag which lets the caller method know what choice has been made by the user.
     */
    public SureFrame(AllEmployees ae, String eName, List ls, Flag yes) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setLocationRelativeTo(null);

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

        setVisible(true);
    }

    /**
     * Constructor method for when the user removes a Route.
     * @param ar The list of all the Routes.
     * @param routeID The ID of the Route to be removed.
     * @param ls The List from which we need to remove the Route.
     * @param yes A flag which lets the caller method know what choice has been made by the user.
     */
    public SureFrame(AllRoutes ar, int routeID, List ls, Flag yes) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setLocationRelativeTo(null);

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

        setVisible(true);
    }
}
