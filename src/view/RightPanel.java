package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    private Controller controller;
    private JPanel yourGamePanel, shipInfoPanel, highscorePanel;
    private JTextArea taShipinfo, taYourGame, taHighscore;
    private JLabel shots, res, playerName;
    
    public RightPanel(Controller controller) {
        this.controller = controller;
        initPanel();
    }

    private void initPanel() {
        yourGamePanel = new JPanel();
        yourGamePanel.setPreferredSize(new Dimension(280, 200));
        yourGamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        yourGamePanel.setBorder(BorderFactory.createTitledBorder("Your game"));

        playerName = new JLabel("");
        playerName.setPreferredSize(new Dimension(240, 15));
        yourGamePanel.add(playerName);

        shots = new JLabel("");
        shots.setPreferredSize(new Dimension(240, 15));
        yourGamePanel.add(shots);

        res = new JLabel("");
        res.setFont(new Font("Calibri", Font.PLAIN, 20));
        res.setPreferredSize(new Dimension(240, 30));
        yourGamePanel.add(res);

        highscorePanel = new JPanel();
        highscorePanel.setPreferredSize(new Dimension(280, 260));
        highscorePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        highscorePanel.setBorder(BorderFactory.createTitledBorder("Highscore"));
        taHighscore = new JTextArea();
        taHighscore.setPreferredSize(new Dimension(260, 220));
        taHighscore.setEditable(false);
        highscorePanel.add(taHighscore);

        shipInfoPanel = new JPanel();
        shipInfoPanel.setPreferredSize(new Dimension(280, 135));
        shipInfoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        shipInfoPanel.setBorder(BorderFactory.createTitledBorder("Ship information"));

        String st = String.format("%10s%30s\n %10s%30s\n %10s%30s\n %10s%30s\n %10s%30s",
                "1x1 box", "Submarine", "2x1 boxes", "Torpedo", "3x1 boxes", "Hunter", "4x1 boxes", "Cruiser", "5x1 boxes", "Battleship" );
        taShipinfo = new JTextArea(st);
        taShipinfo.setPreferredSize(new Dimension(260, 100));
        taShipinfo.setEditable(false);
        shipInfoPanel.add(taShipinfo);

        add(yourGamePanel);
        add(highscorePanel);
        add(shipInfoPanel);


    }

    public void setName(String text) {
        this.playerName.setText("Name: " + text);
    }

    public void setGameEvents(String text) {
        this.res.setText(text);
    }

    public void setHighscore(String text) {
        this.taHighscore.setText(text);
    }

    public void shoot(int shots) {
        this.shots.setText("Total shots fired: " + String.valueOf(shots));
    }

    public void reset() {
        shots.setText("Total shots fired: 0");
        playerName.setText("Name: ");
        res.setText("");
    }


}
