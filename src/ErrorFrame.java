import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorFrame extends Frame {
    private JLabel errorMessage = new JLabel("");

    public ErrorFrame() {
        int w = 250;
        int h = 160;
        setTitle("ERROR!");
        setVisible(false);
        setSize(w, h);
        setLayout(null);
        setLocationRelativeTo(null);

        Button cancelButton = new Button("Cancel");

        errorMessage.setHorizontalAlignment(JLabel.CENTER);
        errorMessage.setBounds(20, 30, 210, 70);

        cancelButton.setBounds(90, 110, 60, 25);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                setLocationRelativeTo(null);
            }
        });

        add(errorMessage);
        add(cancelButton);
    }

    public void displayError(String errorMsg) {
        errorMessage.setText(errorMsg);
        setVisible(true);
    }
}
