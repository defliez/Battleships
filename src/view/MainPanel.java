package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    private Controller controller;
    private CenterPanel centerPanel;
    private RightPanel rightPanel;
    private SouthPanel southPanel;

    public MainPanel(Controller controller) {
        this.controller = controller;
        initPanel();
    }

    private void initPanel() {
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        Border border = this.getBorder();
        Border borderMargin = BorderFactory.createEmptyBorder(8,8,8,8);
        setBorder(new CompoundBorder(border, borderMargin));

        rightPanel = new RightPanel(controller);
        rightPanel.setPreferredSize(new Dimension(300, 505));
        add(rightPanel, BorderLayout.EAST);

        southPanel = new SouthPanel(controller);
        add(southPanel, BorderLayout.SOUTH);

        centerPanel = new CenterPanel(controller);
        centerPanel.setPreferredSize(new Dimension(600, 600));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Gameplay..."));
        add(centerPanel, BorderLayout.CENTER);
    }

    public void reset() {
        centerPanel.reset();
        rightPanel.reset();
    }

    public void shoot(int shots) {
        rightPanel.shoot(shots);
    }
    public void setGameEvents(String text) {
        rightPanel.setGameEvents(text);
    }
    public void setHighscore(String text) {
        rightPanel.setHighscore(text);
    }
    public void setName(String text) {
        rightPanel.setName(text);
    }
}
