package model;

public class Player implements Comparable<Player> {

    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return String.format(" Name: %s, Score: %s", name, score);
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(score, other.score);
    }
}
