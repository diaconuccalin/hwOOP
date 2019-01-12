import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVehicleFrame extends Frame {
    public AddVehicleFrame(List ls, AllVehicles vp, ErrorFrame ef) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Add Vehicle");
        setLocationRelativeTo(null);
        setVisible(true);


        Label idLabel = new Label("ID:", Label.RIGHT);
        TextField idTF = new TextField();

        idLabel.setBounds(20, 50, 40, 18);
        idTF.setBounds(65, 50, 150, 18);


        Label typeLabel = new Label("Type:", Label.RIGHT);
        Choice typeChoice = new Choice();

        typeChoice.add("BUS");
        typeChoice.add("TROLLEYBUS");
        typeChoice.add("SERVICE VEHICLE");

        typeLabel.setBounds(20, 70, 40, 15);
        typeChoice.setBounds(65, 70, 150, 15);


        Button addButton = new Button("Add");
        Button cancelButton = new Button("Cancel");

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeString = typeChoice.getSelectedItem();
                String idString = idTF.getText();
                int auxID = 0;
                int error = 0;

                try {
                    auxID = Integer.parseInt(idString);
                } catch (NumberFormatException err) {
                    ef.displayError("<html>ID must be integer!</html>");
                    error = 1;
                }

                if(error == 0) {
                    int index = 0;

                    switch (typeString) {
                        case "BUS":
                            Vehicle aux = new Vehicle(auxID, Vehicle.vehicleType.BUS);
                            index = vp.addVehicle(aux);
                            break;
                        case "TROLLEYBUS":
                            Vehicle aux2 = new Vehicle(auxID, Vehicle.vehicleType.TROLLEYBUS);
                            index = vp.addVehicle(aux2);
                            break;
                        case "SERVICE VEHICLE":
                            Vehicle aux3 = new Vehicle(auxID, Vehicle.vehicleType.SERVICE);
                            index = vp.addVehicle(aux3);
                            break;
                    }

                    ls.add(typeString + " - " + idString, index);
                }
                dispose();
            }
        });

        addButton.setBounds(65, 100, 50, 20);
        cancelButton.setBounds(125, 100, 50, 20);


        add(idLabel);
        add(idTF);
        add(typeChoice);
        add(typeLabel);
        add(addButton);
        add(cancelButton);
    }
}
