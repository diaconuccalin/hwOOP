/**
 * <h1>Error frame</h1>
 * A window used to display warning regarding different errors.
 * <br>It will be automatically created when a MainFrame is created, but set as invisible and only displayed when
 * needed.
 * <br>It will be a 250x160 window with a text that will be modified accordingly to the problem and a Close button
 * to hide the frame (set its visibility to false).
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorFrame extends Frame {
    private JLabel errorMessage = new JLabel("");

    /**
     * Constructor method.
     */
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

    /**
     * Used to make the window visible and display the needed message.
     * @param errorMsg The message to be displayed.
     */
    public void displayError(String errorMsg) {
        errorMessage.setText(errorMsg);
        setVisible(true);
    }
}
