package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Highscore {

    private List<Player> highscoreBoard;
    private static final int MAX_PLAYERS = 10;
    private BufferedWriter writer;
    private BufferedReader reader;

    public Highscore() {
        highscoreBoard = new ArrayList<>();
        try {
            readFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile() throws IOException {
        reader = new BufferedReader(new FileReader("src/Highscore.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);
            addPlayer(name, score);
        }
        reader.close();
    }

    //
    public void writeToFile() throws IOException {
        writer = new BufferedWriter(new FileWriter("src/Highscore.txt"));
        for (Player player : highscoreBoard) {
            writer.write(player.getName() + ", " + player.getScore() + "\n");
        }
        writer.flush();
        writer.close();
    }

    public void addPlayer(String name, int score) {
        Player newPlayer = new Player(name, score);
        highscoreBoard.add(newPlayer);
        Collections.sort(highscoreBoard);
        if (highscoreBoard.size() > MAX_PLAYERS) {
            highscoreBoard = highscoreBoard.subList(0, MAX_PLAYERS);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (Player player : highscoreBoard) {
            sb.append(count).append(". ").append(player.getName()).append(": ").append(player.getScore()).append("\n");
            count++;
        }
        return sb.toString();
    }

}
