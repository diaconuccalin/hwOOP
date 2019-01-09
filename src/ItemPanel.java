import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemPanel extends Frame{
    public ItemPanel(String panelName) {
        int w = 400;
        int h = 600;

        setVisible(true);
        setLayout(null);
        setSize(w, h);
        setTitle(panelName);


        Label l1 = new Label("Info", Label.CENTER);
        Label l2 = new Label("Control", Label.CENTER);

        l1.setBounds(20, 40, 170, 20);
        l2.setBounds(210, 40, 170, 20);


        Panel p1 = new Panel();
        Panel p2 = new Panel();

        p1.setBackground(Color.lightGray);
        p2.setBackground(Color.lightGray);

        p1.setBounds(20, 70, 170, 480);
        p2.setBounds(210, 70, 170, 480);


        Button cancelButton = new Button("Cancel");
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
