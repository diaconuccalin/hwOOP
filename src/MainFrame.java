import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends Frame{
    private List ls1 = new List();
    private List ls2 = new List();
    private List ls3 = new List();
    private List ls4 = new List();

    private VehiclePark vp = new VehiclePark();

    private ErrorFrame ef = new ErrorFrame();


    public MainFrame() {
        int w = 1500;
        int h = 800;


        Label l1 = new Label("Vehicles", Label.CENTER);
        Label l2 = new Label("Stops", Label.CENTER);
        Label l3 = new Label("Routes", Label.CENTER);
        Label l4 = new Label("Employees", Label.CENTER);

        l1.setBounds(40, 40, 250, 20);
        l2.setBounds(330, 40, 250, 20);
        l3.setBounds(620, 40, 250, 20);
        l4.setBounds(910, 40, 250, 20);


        ls1.setBounds(40, 70, 250, 630);
        ls2.setBounds(330, 70, 250, 630);
        ls3.setBounds(620, 70, 250, 630);
        ls4.setBounds(910, 70, 250, 630);


        Label b1 = new Label("Depots");
        Button b2 = new Button("Depot 1");
        Button b3 = new Button("Depot 2");
        Button b4 = new Button("Depot 3");

        b1.setBounds(40, 740, 250, 40);
        b2.setBounds(330, 740, 250, 40);
        b3.setBounds(620, 740, 250, 40);
        b4.setBounds(910, 740, 250, 40);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemFrame ip = new ItemFrame(b2.getLabel());
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemFrame ip = new ItemFrame(b3.getLabel());
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemFrame ip = new ItemFrame(b4.getLabel());
            }
        });


        Panel controlPanel = new Panel();
        controlPanel.setBackground(Color.lightGray);
        controlPanel.setBounds(1200, 40, 250, 740);
        controlPanel.setLayout(null);


        Button closeButton = new Button("Close");
        closeButton.setBounds(75, 680, 100, 40);
        controlPanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        Button addVehicleButton = new Button("Add Vehicle");
        addVehicleButton.setBounds(10, 10, 230, 30);
        controlPanel.add(addVehicleButton);

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddVehicleFrame avw = new AddVehicleFrame(ls1, vp, ef);
            }
        });


        setLayout(null);
        setSize(w, h);
        setTitle("Main Panel");
        setLocationRelativeTo(null);
        setVisible(true);

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
        add(controlPanel);
    }
}
