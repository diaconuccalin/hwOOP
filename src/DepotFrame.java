import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepotFrame extends Frame{
    public DepotFrame(Depot dep) {
        int w = 400;
        int h = 600;

        setLayout(null);
        setSize(w, h);
        setTitle("Depot: " + dep.getName());
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

        Label nameLabel = new Label("Name: " + dep.getName(), Label.LEFT);
        p1.add(nameLabel);
        nameLabel.setBounds(2, 0, 170, 18);

        Label capacityLabel = new Label("Capacity: " + dep.getCapacity(), Label.LEFT);
        p1.add(capacityLabel);
        capacityLabel.setBounds(2, 15, 170, 18);

        Label idLabel = new Label("ID: " + dep.getId(), Label.LEFT);
        p1.add(idLabel);
        idLabel.setBounds(2, 30, 170, 18);

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
