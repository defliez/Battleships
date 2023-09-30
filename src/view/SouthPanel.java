package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel implements ActionListener{

    private Controller controller;
    private JButton btnRestart;

    public SouthPanel(Controller controller) {
        this.controller = controller;
        initButtons();
    }

    public void initButtons() {
        ActionListener listener = new ButtonActionListeners();
        btnRestart = new JButton("Restart");
        add(btnRestart);
        btnRestart.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(Buttons.btnRestart)){}
    }

    class ButtonActionListeners implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == btnRestart){
                System.out.println("Restart");
                controller.reset();
            }
        }
    }





}
