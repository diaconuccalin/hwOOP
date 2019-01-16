/**
 * <h1>Add Vehicle frame</h1>
 * The AddVehicleFrame class is the window which enables the user to add a new Vehicle to an AllVehicles
 * object and to the list that displays all the employees.
 * <br>It creates a 250x150 window which shows a text field, where the user must put the new Vehicle's id
 * (only integers accepted), a Choice for selecting the Vehicle's type and two buttons, Add and Cancel,
 * for finishing or canceling the addition.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVehicleFrame extends Frame {
    /**
     * This is the constructor. It needs the List and the AllVehicles, to which it will add the
     * newly created Vehicle after the Add button is pressed, and also the ErrorFrame
     * which will prevent the user from entering an id that is not an integer.
     * @param ls The List object to which the newly created Vehicle's id and type will be added.
     * @param vp The AllVehicles object to which the newly created Vehicle will be added.
     * @param ef For the ErrorFrame which will inform the user that the id needs to be an integer.
     */
    public AddVehicleFrame(List ls, AllVehicles vp, ErrorFrame ef) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Add Vehicle");
        setLocationRelativeTo(null);

        Label idLabel = new Label("ID:", Label.RIGHT);
        TextField idTF = new TextField();

        idLabel.setBounds(20, 50, 40, 18);
        idTF.setBounds(65, 50, 150, 18);

        Label typeLabel = new Label("Type:", Label.RIGHT);
        Choice typeChoice = new Choice();

        typeLabel.setBounds(20, 70, 40, 15);
        typeChoice.setBounds(65, 70, 150, 15);

        typeChoice.add("BUS");
        typeChoice.add("TROLLEYBUS");
        typeChoice.add("SERVICE VEHICLE");

        Button addButton = new Button("Add");
        Button cancelButton = new Button("Cancel");

        addButton.setBounds(65, 100, 50, 20);
        cancelButton.setBounds(125, 100, 50, 20);

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

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(idLabel);
        add(idTF);
        add(typeChoice);
        add(typeLabel);
        add(addButton);
        add(cancelButton);

        setVisible(true);
    }
}
