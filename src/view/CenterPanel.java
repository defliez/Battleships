package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CenterPanel extends JPanel{
    
    private Controller controller;
    private JButton[][] buttons;

    public CenterPanel(Controller controller) {
        this.controller = controller;
        buttons = new JButton[10][10];
        addButtons();
    }

    private void addButtons() {
        GridLayout layout = new GridLayout(10, 10, 5, 5);
        ActionListener listener = new CenterPanel.ButtonActionListeners();
        setLayout(layout);
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                buttons[y][x] = new JButton(" ");
                add(buttons[y][x]);
                buttons[y][x].addActionListener(listener);
            }
        }
    }

    public void reset() {
        for(int y = 0; y < 10; y++) {
            for (int x = 0; x<10; x++) {
                buttons[y][x].setEnabled(true);
                buttons[y][x].setText(" ");
                buttons[y][x].setOpaque(false);
            }
        }
    }

    class ButtonActionListeners implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();  //Sets the object clicked on, in "button"
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    if (buttons[y][x].equals(button)) {
                        buttons[y][x].setEnabled(false);
                        if(controller.fireAt(y, x)) {
                            buttons[y][x].setText("Hit!");
                            buttons[y][x].setBackground(Color.RED);
                            buttons[y][x].setOpaque(true);

                        }
                        break;
                    }
                }
            }
            try {
                controller.winCondition();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void setPreferredSize(Dimension dimension) {
    }

    public void setBorder(Border lineBorder) {
    }
}
