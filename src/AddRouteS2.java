import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRouteS2 extends Frame {
    public AddRouteS2(Route r, AllStops as, List ls, AllRoutes ar) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Add Route");
        setLocationRelativeTo(null);
        setVisible(true);

        Label stopLabel = new Label("Stop:", Label.RIGHT);
        Choice stopChoice = new Choice();

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

        stopLabel.setBounds(20, 50, 40, 18);
        stopChoice.setBounds(65, 50, 150, 18);

        Button addButton = new Button("Add");
        Button doneButton = new Button("Done");
        Button cancelButton = new Button("Cancel");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r.addStop(new Stop(stopChoice.getSelectedItem()));
                AddRouteS2 ar2 = new AddRouteS2(r, as, ls, ar);
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
                ar.removeRoute(r.getId());
                dispose();
            }
        });

        addButton.setBounds(40, 100, 50, 20);
        doneButton.setBounds(100, 100, 50, 20);
        cancelButton.setBounds(160, 100, 50, 20);

        add(stopLabel);
        add(stopChoice);
        add(addButton);
        add(cancelButton);
        add(doneButton);

        if((n - nr) == 0) {
            ls.add(r.getId() + "");
            dispose();
        }
    }
}
