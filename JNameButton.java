import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivo on 19.2.2017 г..
 */
public class JNameButton extends JButton {
    PlayerPanel panel;

    public JNameButton(PlayerPanel panel) {
        super();
        this.panel = panel;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
