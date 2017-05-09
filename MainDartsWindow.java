import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Ivo on 19.2.2017 г..
 */
public class MainDartsWindow extends JFrame {
    JPanel mainPanel;
    BufferedImage icon;
    PlayerPanel[] playerPanelList;
    int players;

    public MainDartsWindow(int players) {
        super("Darts Scoring System");
        // JFrame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Declaration
        mainPanel = new MainPanel();
        mainPanel.setLayout(new GridLayout(3, 2));

        // Adding players and panels
        this.setContentPane(mainPanel);
        this.players = players;
        this.addPlayers();
        this.addPanels();


        this.importIcon();
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    private void addPlayers() {
        try {
            playerPanelList = new PlayerPanel[players];
        } catch (Exception el) {
            System.err.println("YOU MUST GIVE A POSITIVE NUMBER!");
        }
    }

    public void addPanels() {
        for (int i = 0; i < players; i++) {
            playerPanelList[i] = new PlayerPanel();
            mainPanel.add(playerPanelList[i]);
        }
        playerPanelList[0].setTurn(true);
    }

    public void putPanelsInContainer() {
        for (int i = 0; i < players; i++) {

        }
    }

    // Creating the icon
    public void importIcon() {
        try {
            icon = ImageIO.read(getClass().getResource("dartsIcon.png"));
        } catch (Exception el) {
            System.err.println("Error occurred while uploading image");
        }
        this.setIconImage(icon);
    }

    // Main Panel class
    private class MainPanel extends JPanel {
        BufferedImage img;

        // Constructor that will take the image
        public MainPanel() {
            super();
            try {
                img = ImageIO.read(getClass().getResource("darts.jpg"));
            } catch (Exception el) {
                System.err.println("Error occurred while uploading image");
            }
        }

        // Image set as a background
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, -850, -300, null);
            repaint();
        }
    }

    public void changeTurns() {

    }
}
