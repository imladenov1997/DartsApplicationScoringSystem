import javax.swing.*;
import java.awt.*;

/**
 * Created by Ivo on 20.2.2017 г..
 */
public class WinnerFrame extends JFrame {
    PlayerPanel panel;
    JPanel mainPanel;
    public WinnerFrame(PlayerPanel panel) {
        super("We have a winner!");
        mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        this.panel = panel;
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JLabel("Congratulations, " + panel.getName() + "! You won this game!"), BorderLayout.CENTER);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}
