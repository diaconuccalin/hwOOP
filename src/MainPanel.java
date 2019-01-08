import java.awt.*;

public class MainPanel extends Frame{
    public static void main(String[] args) {
        MainPanel mp = new MainPanel();
    }

    public MainPanel() {
        int w = 1200;
        int h = 800;
        int r = 3;
        int c = 4;

        GridBagLayout gbl = new GridBagLayout();
        GridLayout gl = new GridLayout(r, c);

        Label l1 = new Label("Vehicles", Label.CENTER);
        Label l2 = new Label("Stops", Label.CENTER);
        Label l3 = new Label("Routes", Label.CENTER);
        Label l4 = new Label("Employees", Label.CENTER);

        l1.setSize(w/4, 20);
        l2.setSize(w/4, 20);
        l3.setSize(w/4, 20);
        l4.setSize(w/4, 20);

        List ls1 = new List();
        List ls2 = new List();
        List ls3 = new List();
        List ls4 = new List();

        ls1.setSize(w/4, 500);

        Label b1 = new Label("Depots");
        Button b2 = new Button("Depot 1");
        Button b3 = new Button("Depot 2");
        Button b4 = new Button("Depot 3");

        b1.setSize(w/4, 20);
        b2.setSize(w/4, 20);
        b3.setSize(w/4, 20);
        b4.setSize(w/4, 20);

        setVisible(true);
        setLayout(gbl);
        setSize(w, h);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(ls1);
        add(ls2);
        add(ls3);
        add(ls4);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
    }
}
