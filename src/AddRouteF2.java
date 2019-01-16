import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRouteF2 extends Frame {
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
