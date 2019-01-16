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
        setSize(w, h);
        setLayout(null);
        setLocationRelativeTo(null);

        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setBounds(20, 30, 210, 70);

        Button cancelButton = new Button("Close");
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

        setVisible(false);
    }

    public void displayError(String errorMsg) {
        errorMessage.setText(errorMsg);
        setVisible(true);
    }
}
