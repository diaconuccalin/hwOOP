import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopFrame extends Frame {
    private Label[] routeLabel = new Label[30];

    public StopFrame(Stop s, int[][] distances) {
        int w = 400;
        int h = 600;

        setLayout(null);
        setSize(w, h);
        setTitle("Stop: " + s.getName());
        setLocationRelativeTo(null);
        setVisible(true);


        Label l1 = new Label("Info", Label.CENTER);
        Label l2 = new Label("Routes", Label.CENTER);

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
        p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));

        Label nameLabel = new Label("Name: " + s.getName(), Label.LEFT);
        p1.add(nameLabel);
        nameLabel.setBounds(2, 0, 170, 18);

        Label idLabel = new Label("ID: " + s.getId(), Label.LEFT);
        p1.add(idLabel);
        idLabel.setBounds(2, 15, 170, 18);

        AllRoutes aux = s.getAr();
        Route[] allR = aux.getAll();

        for(int i = 0; i < aux.getN(); i++) {
            routeLabel[i] = new Label("", Label.CENTER);

            if(allR[i].getAv().getN() == 0) {
                routeLabel[i].setText(allR[i].getId() + " - NONE");
            }
            else {
                routeLabel[i].setText(allR[i].getId() + " - " + allR[i].getClosestToStop(s, distances));
            }

            p2.add(routeLabel[i]);
        }

        p2.add(Box.createVerticalStrut(p2.getHeight() - aux.getN() * 20));


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
