import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Stack;

public class MainFrame extends Frame{
    private List ls1 = new List();
    private List ls2 = new List();
    private List ls3 = new List();
    private List ls4 = new List();

    private ErrorFrame ef = new ErrorFrame();

    private AllVehicles vp;
    private AllRoutes ar;
    private AllStops as;
    private AllEmployees ae;
    private AllPlaces ap;
    private Depot d1;
    private Depot d2;
    private Depot d3;

    private int[][] distances = new int[80][80];

    public MainFrame(AllVehicles vp, AllRoutes ar, AllStops as, AllEmployees ae, Depot d1, Depot d2, Depot d3, AllPlaces ap) {
        this.vp = vp;
        this.ar = ar;
        this.as = as;
        this.ae = ae;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.ap = ap;

        for(int i = 0; i < 80; i++)
            Arrays.fill(distances[i], 2000);

        {
            distances[22][0] = 1;

            distances[0][60] = 1;
            distances[0][8] = 1;

            distances[60][46] = 3;
            distances[46][41] = 3;

            distances[41][33] = 3;
            distances[41][10] = 3;
            distances[41][70] = 4;

            distances[33][76] = 2;

            distances[76][2] = 3;

            distances[2][79] = 1;
            distances[2][32] = 1;

            distances[76][79] = 3;
            distances[79][68] = 2;
            distances[68][49] = 2;

            distances[49][48] = 1;
            distances[49][45] = 1;
            distances[49][36] = 2;

            distances[45][25] = 1;
            distances[25][16] = 2;
            distances[25][29] = 1;
            distances[29][27] = 2;
            distances[27][23] = 1;
            distances[23][30] = 1;
            distances[30][78] = 1;
            distances[78][12] = 1;

            distances[12][48] = 1;
            distances[12][36] = 2;

            distances[48][67] = 2;
            distances[67][35] = 1;

            distances[35][32] = 3;
            distances[35][2] = 1;

            distances[32][10] = 5;
            distances[32][70] = 6;
            distances[32][20] = 3;

            distances[20][10] = 4;
            distances[20][70] = 4;
            distances[20][58] = 2;

            distances[58][61] = 1;
            distances[61][34] = 1;
            distances[34][18] = 1;

            distances[18][0] = 1;
            distances[18][8] = 1;

            distances[8][22] = 1;
            distances[8][17] = 3;
            distances[8][47] = 4;



            distances[74][22] = 5;
            distances[74][17] = 4;

            distances[17][53] = 1;

            distances[53][37] = 2;
            distances[53][10] = 4;

            distances[37][58] = 2;
            distances[37][41] = 3;

            distances[10][3] = 2;
            distances[3][11] = 2;
            distances[11][44] = 3;

            distances[44][15] = 3;
            distances[44][77] = 2;

            distances[77][71] = 2;
            distances[77][62] = 2;

            distances[62][59] = 3;
            distances[62][7] = 2;

            distances[7][55] = 1;
            distances[55][42] = 1;
            distances[42][28] = 2;
            distances[28][14] = 1;
            distances[14][40] = 2;
            distances[40][75] = 1;
            distances[75][1] = 1;
            distances[1][21] = 1;
            distances[21][39] = 1;
            distances[39][13] = 1;
            distances[13][4] = 3;
            distances[4][26] = 2;
            distances[26][65] = 2;

            distances[65][59] = 2;
            distances[65][24] = 2;

            distances[24][66] = 2;

            distances[66][15] = 2;
            distances[66][43] = 2;

            distances[43][69] = 2;
            distances[69][31] = 2;
            distances[31][38] = 2;

            distances[38][37] = 2;
            distances[38][70] = 3;

            distances[70][9] = 1;

            distances[9][22] = 3;
            distances[9][47] = 2;

            distances[47][74] = 3;


            distances[15][19] = 2;
            distances[19][54] = 2;
            distances[54][72] = 2;
            distances[72][56] = 2;

            distances[56][66] = 4;
            distances[56][71] = 4;
            distances[56][62] = 4;

            distances[71][64] = 3;

            distances[64][48] = 3;
            distances[64][45] = 2;

            distances[36][52] = 4;

            distances[52][51] = 2;
            distances[52][73] = 1;

            distances[51][62] = 1;
            distances[51][66] = 2;

            distances[73][63] = 2;
            distances[63][6] = 2;

            distances[6][42] = 2;
            distances[6][26] = 2;


            distances[59][57] = 2;
            distances[57][50] = 2;
            distances[50][5] = 2;

            distances[5][24] = 4;
            distances[5][56] = 4;
        }

        for(int i = 0; i < 80; i++) {
            dijkstra(i);
        }
    }

    private int minDistance(int[] dist, boolean[] sptSet) {
        int min = 2000;
        int minIndex = -1;

        for(int v = 0; v < 80; v++) {
            if(!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void dijkstra(int src) {
        int[] dist = new int[80];
        boolean[] sptSet = new boolean[80];

        for(int i = 0; i < 80; i++) {
            dist[i] = 2000;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for(int count = 0; count < 79; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for(int v = 0; v < 80; v++) {
                if(!sptSet[v] && distances[u][v] != -1 && dist[u] != 2000 && dist[u] + distances[u][v] < dist[v]) {
                    dist[v] = dist[u] + distances[u][v];
                }
            }
        }

        System.arraycopy(dist, 0, distances[src], 0, 80);
    }

    public void run() {
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


        ls1.setBounds(20, 65, 136, 350);
        ls2.setBounds(176, 65, 136, 350);
        ls3.setBounds(332, 65, 136, 350);
        ls4.setBounds(488, 65, 136, 350);

        ls1.select(0);
        ls2.select(0);
        ls3.select(0);
        ls4.select(0);


        Label b1 = new Label("Depots");
        Button b2 = new Button(d1.getName());
        Button b3 = new Button(d2.getName());
        Button b4 = new Button(d3.getName());

        b1.setBounds(20, 460, 136, 20);
        b2.setBounds(176, 460, 136, 20);
        b3.setBounds(332, 460, 136, 20);
        b4.setBounds(488, 460, 136, 20);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepotFrame ip = new DepotFrame(d1, ef, distances, ar, ae, d1, d2, d3);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepotFrame ip = new DepotFrame(d2, ef, distances, ar, ae, d1, d2, d3);
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepotFrame ip = new DepotFrame(d3, ef, distances, ar, ae, d1, d2, d3);
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


        int vn = vp.getN();
        Vehicle[] allV = vp.getPark();
        for(int i = 0; i < vn; i++) {
            ls1.add(allV[i].getType() + " - " + allV[i].getId());
        }

        int sn = as.getN();
        Stop[] allS = as.getAll();
        for(int i = 0; i < sn; i++) {
            ls2.add(allS[i].getName());
        }

        int rn = ar.getN();
        Route[] allR = ar.getAll();
        for(int i = 0; i < rn; i++) {
            ls3.add(allR[i].getId() + "");
        }

        int en = ae.getN();
        Employee[] allE = ae.getAll();
        for(int i = 0; i < en; i++) {
            ls4.add(allE[i].getName());
        }


        Button seeVehicleDetails = new Button("Vehicle Details");
        Button seeStopDetails = new Button("Stop Details");
        Button seeRouteDetails = new Button("Route Details");
        Button seeEmployeeDetails = new Button("Employee Details");

        seeVehicleDetails.setBounds(20, 420, 136, 20);
        seeStopDetails.setBounds(176, 420, 136, 20);
        seeRouteDetails.setBounds(332, 420, 136, 20);
        seeEmployeeDetails.setBounds(488, 420, 136, 20);


        seeVehicleDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedVehicle = ls1.getSelectedItem();
                    StringBuilder selVehID = new StringBuilder();

                    boolean found = false;

                    for (int i = 0; i < selectedVehicle.length(); i++) {
                        if (selectedVehicle.charAt(i) == '-') {
                            found = true;
                            i += 2;
                        }

                        if (found) {
                            selVehID.append(selectedVehicle.charAt(i));
                        }
                    }

                    Vehicle toSee = vp.findVehicle(Integer.parseInt(selVehID.toString()));
                    VehicleFrame vf = new VehicleFrame(toSee, vp, ls1, ar, ae, distances, d1, d2, d3);
                } catch (NullPointerException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });

        seeStopDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedStop = ls2.getSelectedItem();
                    Stop stopToSee = as.getStop(selectedStop);
                    StopFrame sf = new StopFrame(stopToSee);
                } catch (NullPointerException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });

        seeRouteDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedRoute = ls3.getSelectedItem();
                    Route routeToSee = ar.getRoute(selectedRoute);
                    RouteFrame rf = new RouteFrame(routeToSee, as, ef, ar, ls3);
                } catch(NullPointerException | NumberFormatException npe) {
                    ef.displayError("No item selected!");
                }
            }
        });

        seeEmployeeDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedEmployee = ls4.getSelectedItem();
                    Employee employeeToSee = ae.getEmployee(selectedEmployee);
                    EmployeeFrame ef = new EmployeeFrame(employeeToSee, ls4, ae);
                } catch (NullPointerException npe) {
                    ef.displayError("No item selected!");
                }
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
        add(seeVehicleDetails);
        add(seeEmployeeDetails);
        add(seeRouteDetails);
        add(seeStopDetails);
    }

    public void passTime(int time) {
        vp.passTime(time, distances);
        ae.passTime(time, ef);
    }
}
