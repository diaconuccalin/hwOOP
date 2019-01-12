import java.awt.*;

public class TimeControlFrame extends Frame {
    public TimeControlFrame(MainFrame mf) {
        int w = 250;
        int h = 100;

        setTitle("Time Control");
        setVisible(true);
        setSize(w, h);
        setLayout(null);
        Point p = mf.getLocation();
        setLocation(p.x + 790, p.y);

        Button btn1s = new Button("> 1 minute");
        btn1s.setBounds(75, 45, 100, 30);
        add(btn1s);
    }
}
