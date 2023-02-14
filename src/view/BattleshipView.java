package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BattleshipView extends JFrame {
    private JButton[][] gridButtons = new JButton[10][10];
    private JLabel statusLabel = new JLabel("Welcome to Battleship!");

    public BattleshipView() {
        initUI();
    }

    private void initUI() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(10, 10));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton button = new JButton();
                gridButtons[i][j] = button;
                gridPanel.add(button);
            }
        }

        add(gridPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setTitle("Battleship");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addButtonListener(ActionListener listener) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gridButtons[i][j].addActionListener(listener);
            }
        }
    }

    public void processHit(int x, int y, boolean isHit) {
        JButton button = getGridButtons()[x][y];
        button.setEnabled(false);
        if (isHit) {
            button.setBackground(Color.GREEN);
            button.setOpaque(true);
        } else {
            button.setBackground(Color.WHITE);
        }
    }





    public void updateGrid(int i, int j, boolean hit) {
        if (hit) {
            gridButtons[i][j].setBackground(Color.GREEN);
            gridButtons[i][j].setOpaque(true);
        } else {
            gridButtons[i][j].setBackground(Color.WHITE);
        }
    }


    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    public JButton[][] getGridButtons() {
        return gridButtons;
    }
}
