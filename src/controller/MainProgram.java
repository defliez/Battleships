package controller;

import model.Board;
import view.BattleshipView;

public class MainProgram {

    /**
     * Main method to run the program.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board model = new Board(2);
        BattleshipView view = new BattleshipView();
        Controller controller = new Controller(model, view);
        view.addButtonListener(controller);
        view.setVisible(true);
    }

}
