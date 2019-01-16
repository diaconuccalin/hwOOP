/**
 * <h1>Add Employee frame</h1></h1>
 * The AddEmployeeFrame class is the window which enables the user to add more employees
 * to an AllEmployees object and also to the list that displays all the employees.
 * <br>It creates a 250x150 window, which shows a text field, for the new employee name, and
 * two buttons, which gives the user the two options: Add, which completes the addition,
 * and Cancel, which closes the window.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeFrame extends Frame {
    /**
     * This is the constructor. It needs the List and the AllEmployees to which it will add the
     * newly created Employee after the Add button is pressed.
     * @param ls For the list to which it should add the name of the newly created Employee
     * @param ae For the AllEmployees object to which the new Employee will be added.
     */
    public AddEmployeeFrame(List ls, AllEmployees ae) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Add Employee");
        setLocationRelativeTo(null);

        Label nameLabel = new Label("Name:", Label.RIGHT);
        TextField tf = new TextField();

        nameLabel.setBounds(20, 50, 40, 18);
        tf.setBounds(65, 50, 150, 18);

        Button addButton = new Button("Add");
        Button cancelButton = new Button("Cancel");

        addButton.setBounds(65, 100, 50, 20);
        cancelButton.setBounds(125, 100, 50, 20);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inp = tf.getText();
                Employee emp = new Employee(inp);


                int index = ae.addEmployee(emp);
                ls.add(inp, index);

                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(nameLabel);
        add(tf);
        add(addButton);
        add(cancelButton);

        setVisible(true);
    }
}
