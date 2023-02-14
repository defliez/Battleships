package controller;

import model.Board;
import model.Result;
import view.BattleshipView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    //private MainFrame view;
    private BattleshipView view;
    private Board model;

    public Controller(Board model, BattleshipView view) {
        this.model = model;
        this.view = view;
        //view = new MainFrame(1000, 2000, this);
        view.addButtonListener(this);

        /*
        Board board = new Board(2);

        System.out.println(board.toString());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter x coordinate: ");
            int x = scanner.nextInt();
            System.out.println("Enter y coordinate: ");
            int y = scanner.nextInt();
            Position position = board.getBoard()[x][y];
            System.out.println(board.getBoard()[x][y].isShip(x, y));
        }

         */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (e.getSource() == view.getGridButtons()[i][j]) {
                    boolean hit = model.getShipLocations()[i][j];
                    view.updateGrid(i, j, hit);
                    if (hit) {
                        view.setStatus("Hit!");
                        handleGridButtonPress(i, j);
                    } else {
                        view.setStatus("Miss!");
                        handleGridButtonPress(i, j);
                    }
                    break;
                }
            }
        }
    }

    private void handleGridButtonPress(int x, int y) {
        boolean[][] shipLocations = model.getShipLocations();
        Result result = model.checkHit(x, y);
        if (shipLocations[x][y] && result == Result.HIT) {
            view.updateGrid(x, y, true);
            view.processHit(x, y, true);
        } else if (!shipLocations[x][y] && result == Result.MISS) {
            view.updateGrid(x, y, false);
            view.processHit(x, y, false);
        }
        if (model.getNumRemainingShips() == 0) {
            JOptionPane.showMessageDialog(view, "All ships have been sunk! You win!");
        }
    }
}
