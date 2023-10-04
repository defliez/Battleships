package controller;

import model.Board;
import model.Highscore;
import model.Player;
import view.MainFrame;
import java.io.IOException;

public class Controller {

    private MainFrame view;
    private Board model;
    private Highscore highscore;
    private Player player;
    private int shots;
    private String name;

    public Controller() {
        view = new MainFrame(this);
        highscore = new Highscore();
        view.setHighscore(highscore.toString());
        reset();
    }

    public void winCondition() throws IOException {
        boolean win = model.winCondition();
        if(win) {
            showMessage("You sank all the ships!");

            player.setScore(shots);
            highscore.addPlayer(player.getName(), player.getScore());
            view.setHighscore(highscore.toString());
            highscore.writeToFile();
            reset();
        }
    }


    public boolean fireAt(int x, int y) {
        shoot();
        return model.fireAt(x,y);
    }
    public void shoot() {
        shots++;
        view.shoot(shots);
    }

    public void setGameEvents(String text) {
        view.setGameEvents(text);
    }
    public void showMessage(String text) {
        view.messagePane(text);
    }

    public void reset() {

        name = view.dialogPane("Please enter your name: ").isEmpty() ? "Anonymous" : name;

        model = new Board(this, 1);
        shots = 0;
        player = new Player(name, 0);

        view.reset();
        view.setName(name);
    }
}
