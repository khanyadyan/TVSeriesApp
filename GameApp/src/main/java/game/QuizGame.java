package game;

import java.util.Scanner;

public class QuizGame {
    private String[] questions;
    private String[][] options;
    private int[] answers; // index of correct option
    private Player[] players;
    private Scanner scanner = new Scanner(System.in);

    public QuizGame(int maxPlayers) {
        // sample questions
        questions = new String[] {
            "What is the capital of France?",
            "What is 2 + 2?",
            "Which color mixes to make green?"
        };
        options = new String[][] {
            {"Paris","London","Rome","Berlin"},
            {"3","4","5","6"},
            {"Red","Blue","Yellow","Black"}
        };
        answers = new int[] {0,1,1}; // Paris, 4, Blue+Yellow -> Blue index used as example (we'll award for option 1)
        players = new Player[maxPlayers];
    }

    public void addPlayer(String playerId, String name, int age, int slot) {
        players[slot] = new Player(playerId, name, age);
    }

    public void playForPlayer(int slot) {
        Player p = players[slot];
        if (p == null) {
            System.out.println("No player in slot " + slot);
            return;
        }
        System.out.println("Player: " + p.getName());
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i+1) + ". " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println("  " + (j+1) + ") " + options[i][j]);
            }
            System.out.print("Answer (1-4): ");
            String ans = scanner.nextLine();
            try {
                int chosen = Integer.parseInt(ans) - 1;
                if (chosen == answers[i]) {
                    p.addScore(1);
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, counted as wrong.");
            }
        }
        System.out.println("Player " + p.getName() + " score: " + p.getScore());
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Quiz Report ===\n");
        for (int i = 0; i < players.length; i++) {
            Player p = players[i];
            if (p != null) {
                sb.append(p.getPlayerId()).append(" | ").append(p.getName()).append(" | Score: ").append(p.getScore()).append("\n");
            }
        }
        return sb.toString();
    }

    // helper for tests: play simulation by providing answers array
    public void simulatePlayForPlayer(int slot, int[] chosenAnswers) {
        Player p = players[slot];
        if (p == null) return;
        for (int i = 0; i < questions.length && i < chosenAnswers.length; i++) {
            if (chosenAnswers[i] == answers[i]) p.addScore(1);
        }
    }
}