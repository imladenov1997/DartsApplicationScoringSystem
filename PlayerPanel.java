import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivo on 19.2.2017 г..
 */
public class PlayerPanel extends JPanel {
    private String generatedName;
    private JLabel name;
    private JLabel pointsLabel;
    private JPanel text;
    private JPanel buttons;
    private JPanel area = new JPanel();
    private JTextField setName;
    private UpdatePointsButton update;
    private JButton reset;
    private Integer points = 501;
    private Integer lastShot;
    private int pointsPrev;
    private JNameButton nameButton;
    private Dimension dim;
    private boolean won;
    private boolean turn;
    //private JPointsButton pointsButton;


    public PlayerPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setName = new JTextField(30);
        name = new JLabel(" ");
        generatedName = "NAME";
        dim = new Dimension(150, 100);
        text = new JPanel();
        buttons = new JPanel();
        buttons.setOpaque(false);
        nameButton = new JNameButton();
        update = new UpdatePointsButton();
        buttons.add(nameButton);
        buttons.add(update);

        text.add(setName);
        text.setOpaque(false);

        //rigid area panel
        area.setLayout(new BoxLayout(area, BoxLayout.Y_AXIS));
        area.add(Box.createRigidArea(dim));
        area.setOpaque(false);

        this.add(name);
        this.add(area);
        this.add(text);
        this.add(buttons);
        this.add(Box.createRigidArea(new Dimension(10, 50)));
        this.setOpaque(false);
        this.won = false;
        this.turn = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Calibri", Font.BOLD, 16);
        Font points = new Font("Calibri", Font.BOLD, 64);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.fillRect(this.getWidth()/2 - 40, 0, 65, 20);
        g.setColor(Color.WHITE);
        g.drawString(generatedName, this.getWidth() / 2 - 30, 15);
        g.setFont(points);
        g.setColor(new Color(112, 112, 112));
        g.drawString(this.points.toString(), this.getWidth() / 2 - 45, this.getHeight() / 3);
    }



    private class JNameButton extends JButton {
        public JNameButton() {
            super("Submit");
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    generatedName = setName.getText();
                    setText("Rename");
                }
            });
        }
    }

    private class UpdatePointsButton extends JButton {
        int lastPoints;
        public UpdatePointsButton() {
            super("Update");
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (generatedName != "NAME") {
                        try {
                            lastPoints = Integer.parseInt(setName.getText());
                        } catch (Exception el) {
                            System.err.println("NOT A NUMBER! PLEASE TRY AGAIN!");
                            lastPoints = 0;
                        }
                    }
                    else {
                        setName.setText("Please, enter your name!");
                    }
                    play(lastPoints);
                }
            });
        }
    }

    public Integer checkPointsShot(int points) {
        if (points < 0 || points > 180) {
            setName.setText("Don't cheat! Enter a value 0-180");
            return 0;
        }
        return points;
    }

    public void play(int lastPoints) {
        pointsPrev = points;
        int result = points - checkPointsShot(lastPoints);
        if (result > 0) {
            points = result;
        }
        else if (result == 0) {
            setName.setText("CONGRATULATIONS, " + generatedName + "! You won this game!");
            WinnerFrame winner = new WinnerFrame(this);
        }
        else {
            setName.setText("You took more points than necessary... Sorry");
        }
    }

    public String getName() {
        return generatedName;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn() {
        return turn;
    }
}
