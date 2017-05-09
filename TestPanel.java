import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Ivo on 19.2.2017 г..
 */
public class TestPanel extends JPanel {
    BufferedImage img;
    JLabel label;

    public TestPanel() {
        super();
        try {
            img = ImageIO.read(getClass().getResource("darts.jpg"));
        } catch (Exception el) {
            System.err.println("Error occurred while uploading image");
        }
        label = new JLabel((Icon) img);
        this.add(label);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 0, 0, null);
        this.repaint();
    }
}
