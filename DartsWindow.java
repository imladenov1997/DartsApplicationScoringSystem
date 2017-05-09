import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivo on 19.2.2017 г..
 */
public class DartsWindow extends JFrame {
    private MainDartsWindow main;
    private JPanel panel;
    private JPanel elements;
    private JPanel text;
    private JLabel label;
    private int playersNum;
    private SubmitButton submit;
    private JTextField numOfPlayersField;

    public DartsWindow(String name) {
        super(name);
        label = new JLabel("Please, choose number of players: ");
        submit = new SubmitButton(this);
        numOfPlayersField = new JTextField("2", 15);
        panel = new JPanel();
        elements = new JPanel();
        text = new JPanel();
    }

    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        elements.setLayout(new BoxLayout(elements, BoxLayout.Y_AXIS));
        text.add(submit);
        text.add(numOfPlayersField, 0);
        elements.add(label);
        elements.add(text);
        elements.setOpaque(false);
        text.setOpaque(false);

        panel.add(Box.createHorizontalGlue());
        panel.add(elements);
        panel.add(Box.createHorizontalGlue());
        panel.setBackground(new Color(255, 0, 0));

        this.pack();
        this.setVisible(true);
    }


    // Submit button class with Action Listener
    private class SubmitButton extends JButton {
        private int players;
        private DartsWindow frame;

        public SubmitButton(DartsWindow frame) {
            super("Submit");
            this.players = playersNum;
            this.frame = frame;
            this.addActionListener(new ButtonListener());
        }

        private class ButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playersNum = Integer.parseInt(numOfPlayersField.getText());
                } catch (Exception el) {
                    System.err.println("NOT A NUMBER! PLEASE TRY AGAIN");
                }

                if (playersNum > 0) {
                    frame.setVisible(false);
                    frame = null;
                    main = new MainDartsWindow(playersNum);

                }
                else {
                    numOfPlayersField.setText("Positive number required!");
                }
            }
        }
    }

    public static void main(String[] args) {
        DartsWindow window = new DartsWindow("Darts");
        window.init();
    }
}
