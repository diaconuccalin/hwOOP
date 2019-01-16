/**
 * <h1>Add Route frame 1</h1>
 * The AddRouteF1 class is the window which enables the user to add more routes
 * to an AllRoutes object and also to the list that displays all the employees.
 * <br>It creates a 250x150 window, which shows a text field, for the new Route id, and
 * two buttons, which gives the user the two options: Create, which prompts the user to AddRouteF2,
 * and Cancel, which closes the window.
 * <br>It gives an error if the id entered is not an integer.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRouteF1 extends Frame {
    /**
     * This is the constructor. It needs the List and the AllRoutes, to which it will add the
     * newly created Route after the Add button is pressed, and also the ErrorFrame and AllStops
     * to pass further to the AddRouteF2 object that it creates.
     * @param ls For the list to which it should add the name of the newly created Route.
     * @param ar For the AllRoutes object to which it should add the newly created Route.
     * @param ef For the error it should show when the id is not an integer.
     * @param as To pass it to AddRouteF2.
     */
    public AddRouteF1(List ls, AllRoutes ar, ErrorFrame ef, AllStops as){
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Add Route");
        setLocationRelativeTo(null);

        Label idLabel = new Label("ID:", Label.RIGHT);
        TextField idTF = new TextField();

        idLabel.setBounds(20, 50, 40, 18);
        idTF.setBounds(65, 50, 150, 18);

        Button createButton = new Button("Create");
        Button cancelButton = new Button("Cancel");

        createButton.setBounds(65, 100, 50, 20);
        cancelButton.setBounds(125, 100, 50, 20);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = idTF.getText();
                int auxID = 0;
                boolean error = false;

                try {
                    auxID = Integer.parseInt(idString);
                } catch (NumberFormatException err) {
                    ef.displayError("<html>ID must be integer!</html>");
                    error = true;
                }

                if(!error) {
                    Route r = new Route(auxID);
                    ar.addRoute(r);

                    AddRouteF2 ar2 = new AddRouteF2(r, as, ls, ar);
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
        add(createButton);
        add(cancelButton);

        setVisible(true);
    }
}
