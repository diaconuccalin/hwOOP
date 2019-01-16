/**
 * <h1>Time Controller frame</h1>
 * The frame which normally should always be visible. It allows the user to "pass" the time by 1, 10 or 160 minutes.
 * It also keeps track of the time that passed so far, since the beginning of the application.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeControlFrame extends Frame {
    int t = 0;

    /**
     * Constructor method.
     * @param mf The MainFrame relative to which this will be created.
     */
    public TimeControlFrame(MainFrame mf) {
        int w = 250;
        int h = 200;

        setSize(w, h);
        setTitle("Time Control");
        setLayout(null);

        Point p = mf.getLocation();
        setLocation(p.x + 790, p.y);

        Label l = new Label("Time elapsed: " + t + " minutes.", Label.LEFT);
        l.setBounds(50, 45, 150, 30);
        add(l);

        Button btn1 = new Button("1 minute   >");
        btn1.setBounds(50, 80, 150, 30);
        add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.passTime(1);
                t+=1;
                l.setText("Time elapsed: " + t + " minutes.");
            }
        });

        Button btn10 = new Button("10 minute >>");
        btn10.setBounds(50, 115, 150, 30);
        add(btn10);

        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.passTime(10);
                t+=10;
                l.setText("Time elapsed: " + t + " minutes.");
            }
        });

        Button btn160 = new Button("160 minute >>>");
        btn160.setBounds(50, 150, 150, 30);
        add(btn160);

        btn160.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.passTime(160);
                t+=160;
                l.setText("Time elapsed: " + t + " minutes.");
            }
        });

        setVisible(true);
    }
}
