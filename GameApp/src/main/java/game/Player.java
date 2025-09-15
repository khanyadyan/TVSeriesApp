package game;

public class Player extends Person {
    private String playerId;
    private int score;

    public Player() { }

    public Player(String playerId, String name, int age) {
        super(name, age);
        this.playerId = playerId;
        this.score = 0;
    }

    public String getPlayerId() { return playerId; }
    public int getScore() { return score; }
    public void addScore(int pts) { this.score += pts; }
}