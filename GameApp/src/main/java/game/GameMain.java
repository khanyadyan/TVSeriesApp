package game;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizGame game = new QuizGame(2);
        System.out.println("Welcome to the Quiz Game.");
        System.out.print("Enter player 1 name: ");
        String name1 = sc.nextLine();
        game.addPlayer("P1", name1, 20, 0);
        System.out.print("Enter player 2 name: ");
        String name2 = sc.nextLine();
        game.addPlayer("P2", name2, 20, 1);

        System.out.println("Starting game for player 1");
        game.playForPlayer(0);
        System.out.println("Starting game for player 2");
        game.playForPlayer(1);

        System.out.println(game.getReport());
    }
}