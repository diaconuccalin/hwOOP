import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends Frame{
    private List ls1 = new List();
    private List ls2 = new List();
    private List ls3 = new List();
    private List ls4 = new List();

    private ErrorFrame ef = new ErrorFrame();


    public MainFrame(VehiclePark vp, AllRoutes ar, AllStops as, AllEmployees ae) {
        int w = 800;
        int h = 500;


        Label l1 = new Label("Vehicles", Label.CENTER);
        Label l2 = new Label("Stops", Label.CENTER);
        Label l3 = new Label("Routes", Label.CENTER);
        Label l4 = new Label("Employees", Label.CENTER);

        l1.setBounds(20, 40, 136, 20);
        l2.setBounds(176, 40, 136, 20);
        l3.setBounds(332, 40, 136, 20);
        l4.setBounds(488, 40, 136, 20);


        ls1.setBounds(20, 65, 136, 380);
        ls2.setBounds(176, 65, 136, 380);
        ls3.setBounds(332, 65, 136, 380);
        ls4.setBounds(488, 65, 136, 380);


        Label b1 = new Label("Depots");
        Button b2 = new Button("Depot 1");
        Button b3 = new Button("Depot 2");
        Button b4 = new Button("Depot 3");

        b1.setBounds(20, 460, 136, 20);
        b2.setBounds(176, 460, 136, 20);
        b3.setBounds(332, 460, 136, 20);
        b4.setBounds(488, 460, 136, 20);

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
        controlPanel.setBounds(644, 40, 136, 440);
        controlPanel.setLayout(null);


        Button closeButton = new Button("Close");
        closeButton.setBounds(43, 410, 50, 20);
        controlPanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        Button addVehicleButton = new Button("Add Vehicle");
        addVehicleButton.setBounds(8, 10, 120, 20);
        controlPanel.add(addVehicleButton);

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddVehicleFrame avw = new AddVehicleFrame(ls1, vp, ef);
            }
        });


        Button addRouteButton = new Button("Add Route");
        addRouteButton.setBounds(8, 35, 120, 20);
        controlPanel.add(addRouteButton);

        addRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRouteS1 ars = new AddRouteS1(ls3, ar, ef, as);
            }
        });

        Button addEmployeeButton = new Button("Add Employee");
        addEmployeeButton.setBounds(8, 60, 120, 20);
        controlPanel.add(addEmployeeButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployeeFrame aef = new AddEmployeeFrame(ls4, ae);
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
