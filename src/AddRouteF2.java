/**
 * <h1>Add Route frame 2</h1>
 * The AddRouteF2 class is the window which enables the user to finish the addition of more routes
 * to an AllRoutes object and also to the list that displays all the employees.
 * <br>It creates a 250x150 window which shows a Choice for the first or next Stop in the Route
 * and three buttons: Add, which adds the current Stop selected in the Choice field, Done, which
 * keeps the already added Stops and adds the newly created Route to the ls List and the ar AllRoutes.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRouteF2 extends Frame {
    /**
     * This is the constructor. It needs the List and the AllRoutes, to which it will add the
     * newly created Route after the Add button is pressed, and also the ErrorFrame to prevent
     * the user from entering an id that is not an integer and the AllStops object used to display
     * the Stops in the Choice field.
     * @param r For the newly created Route.
     * @param as To add stops to stopChoice Choice object.
     * @param ls For the List to which it should add the newly created Route's id.
     * @param ar For the Routes list to which it should add the r Route object.
     */
    public AddRouteF2(Route r, AllStops as, List ls, AllRoutes ar) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Add Route");
        setLocationRelativeTo(null);

        Label stopLabel = new Label("Stop:", Label.RIGHT);
        Choice stopChoice = new Choice();

        stopLabel.setBounds(20, 50, 40, 18);
        stopChoice.setBounds(65, 50, 150, 18);


        int n = as.getN();
        Stop[] all = as.getAll();

        int nr = r.getN();
        Stop[] allRoute = r.getStops();

        for(int i = 0; i < n; i++) {
            boolean found = false;
            for(int j = 0; j < nr; j++) {
                if(allRoute[j].getName().equals(all[i].getName()))
                    found = true;
            }

            if(!found) {
                stopChoice.add(all[i].getName());
            }
        }


        Button addButton = new Button("Add");
        Button doneButton = new Button("Done");
        Button cancelButton = new Button("Cancel");

        addButton.setBounds(40, 100, 50, 20);
        doneButton.setBounds(100, 100, 50, 20);
        cancelButton.setBounds(160, 100, 50, 20);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stop toAdd = as.getStop(stopChoice.getSelectedItem());
                r.addStop(toAdd);
                toAdd.addRoute(r);
                AddRouteF2 ar2 = new AddRouteF2(r, as, ls, ar);
                dispose();
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ls.add(r.getId() + "", ar.getIndex(r.getId()));
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stop[] s = r.getStops();
                for(int i = 0; i < r.getN(); i++) {
                    s[i].removeRoute(r);
                }
                ar.removeRoute(r.getId());
                dispose();
            }
        });

        if((n - nr) == 0) {
            ls.add(r.getId() + "");
            dispose();
        }

        add(stopLabel);
        add(stopChoice);
        add(addButton);
        add(cancelButton);
        add(doneButton);

        setVisible(true);
    }
}
