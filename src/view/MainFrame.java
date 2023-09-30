package view;

import controller.Controller;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JFrame frame;
    private MainPanel mainPanel;
    private Controller controller;

    public MainFrame(Controller controller) {
        this.controller = controller;
        frame = new JFrame("Battleship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocation(300,300);
        frame.setVisible(true);

        mainPanel = new MainPanel(controller);
        frame.add(mainPanel);
    }

    public void reset() {
       mainPanel.reset();
    }
    public void messagePane(String message) {
        JOptionPane.showMessageDialog(this,message);
    }
    public String dialogPane(String message) {
        return JOptionPane.showInputDialog(this,message);
    }
    public void setGameEvents(String text) {
        mainPanel.setGameEvents(text);
    }
    public void setHighscore(String text) {
        mainPanel.setHighscore(text);
    }
    public void shoot(int shots) {
        mainPanel.shoot(shots);
    }
    public void setName(String text) {
        mainPanel.setName(text);
    }
}
