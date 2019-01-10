import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeFrame extends Frame {
    public AddEmployeeFrame(List ls, AllEmployees ae) {
        int w = 250;
        int h = 150;

        setLayout(null);
        setSize(w, h);
        setTitle("Add Employee");
        setLocationRelativeTo(null);
        setVisible(true);

        Label nameLabel = new Label("Name:", Label.RIGHT);
        TextField tf = new TextField();

        nameLabel.setBounds(20, 50, 40, 18);
        tf.setBounds(65, 50, 150, 18);

        Button addButton = new Button("Add");
        Button cancelButton = new Button("Cancel");

        addButton.setBounds(65, 100, 50, 20);
        cancelButton.setBounds(125, 100, 50, 20);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inp = tf.getText();
                Employee emp = new Employee(inp);

                ls.add(inp);
                ae.addEmployee(emp);

                dispose();
            }
        });

        add(nameLabel);
        add(tf);
        add(addButton);
        add(cancelButton);
    }
}
