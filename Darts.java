/**
 * Created by Ivo on 19.2.2017 г..
 */

import java.util.HashMap;


public class Darts {
    Toolbox myToolbox = new Toolbox();
    int numOfPlayers;
    int points;
    int[] Player;
    int lastResult;
    HashMap<String, Integer> pointMapper = new HashMap<String, Integer>();
    HashMap<Integer, String> playerMapper = new HashMap<Integer, String>();

    public void fixPoints() {
        pointMapper.put("l", 301);
        pointMapper.put("h", 501);
    }

    public void setPlayers(int number) {
        if (number > 0) {
            numOfPlayers = number;
            Player = new int[numOfPlayers];
        }
        else {
            System.out.println("Please enter a positive integer!");
            number = myToolbox.readIntegerFromCmd();
            setPlayers(number);
        }
    }

    public void setPoints(String pts) {

        if (pts.equals("l") || pts.equals("h")) {
            System.out.println("You are about to set the starting points to " + pointMapper.get(pts));
            System.out.println("Press y to proceed. Press any other key to change");
            String choice = myToolbox.readStringFromCmd();
            if (choice.equals("y")) {
                points = pointMapper.get(pts);
            }
            else {
                System.out.println("I knew you would consider ;) ! Please, choose h for 501 points and l for 301 points");
                pts = myToolbox.readStringFromCmd();
                setPoints(pts);
            }
        }
        else {
            System.out.println("Wrong input! Please, choose h for 501 points and l for 301 points");
            pts = myToolbox.readStringFromCmd();
            setPoints(pts);
        }
    }

    public int getPlayers() {
        return numOfPlayers;
    }

    public void initialiseGame() {
        for (int i = 0; i < numOfPlayers; i++) {
            Player[i] = points;
        }
    }

    public void setNames() {
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Player " + (i+1) + " name: ");
            playerMapper.put(i, myToolbox.readStringFromCmd());
        }
    }

    public void game() {
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("********************************");
            System.out.println(playerMapper.get(i) + ": " + Player[i]);
            lastResult = myToolbox.readIntegerFromCmd();
            if (Player[i] < lastResult) {
                System.out.println(playerMapper.get(i) + ": " + Player[i]);
            }
            else if (lastResult > 180) {
                System.out.println("Impossible result. Maximum is 180");
                game();
            }
            else {
                Player[i] = Player[i] - lastResult;
            }
            if (Player[i] == 0) {
                System.out.println("You win!");
                System.out.println("If you want to start a New Game, press any key apart from q");
                System.out.println("If you want to quit, press q");
                if (myToolbox.readStringFromCmd().equals("q")) {
                    System.exit(0);
                }
                else {
                    action();
                }
            }
            System.out.println(playerMapper.get(i) + ": " + Player[i]);
            System.out.println();
            System.out.println();
        }

    }

    public void action() {

        System.out.println("Please choose number of players");
        setPlayers(myToolbox.readIntegerFromCmd());

        System.out.println("Please choose an option: ");
        System.out.println("h : for 501 points");
        System.out.println("l : for 301 points");

        fixPoints();
        setPoints(myToolbox.readStringFromCmd());
        setNames();
        initialiseGame();
    }

    public static void main(String[] args) {
        Toolbox myToolbox = new Toolbox();
        Darts drt = new Darts();

        System.out.println("*****************************************");
        System.out.println("WELCOME TO DARTS GAME SCORING APPLICATION");
        System.out.println("*****************************************");
        drt.action();

        while (true) {
            drt.game();
        }
    }
}