import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRouteF1 extends Frame {
    public AddRouteF1(List ls, AllRoutes ar, ErrorFrame ef, AllStops as){
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Add Route");
        setLocationRelativeTo(null);

        Label idLabel = new Label("ID:", Label.RIGHT);
        TextField idTF = new TextField();

        idLabel.setBounds(20, 50, 40, 18);
        idTF.setBounds(65, 50, 150, 18);

        Button createButton = new Button("Create");
        Button cancelButton = new Button("Cancel");

        createButton.setBounds(65, 100, 50, 20);
        cancelButton.setBounds(125, 100, 50, 20);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = idTF.getText();
                int auxID = 0;
                boolean error = false;

                try {
                    auxID = Integer.parseInt(idString);
                } catch (NumberFormatException err) {
                    ef.displayError("<html>ID must be integer!</html>");
                    error = true;
                }

                if(!error) {
                    Route r = new Route(auxID);
                    ar.addRoute(r);

                    AddRouteF2 ar2 = new AddRouteF2(r, as, ls, ar);
                }

                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(idLabel);
        add(idTF);
        add(createButton);
        add(cancelButton);

        setVisible(true);
    }
}
