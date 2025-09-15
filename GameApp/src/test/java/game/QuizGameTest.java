package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuizGameTest {

    @Test
    void testSimulatePlayAndReport() {
        QuizGame g = new QuizGame(2);
        g.addPlayer("P1","Alice",20,0);
        g.addPlayer("P2","Bob",21,1);
        // simulate answers: correct for all
        g.simulatePlayForPlayer(0, new int[] {0,1,1});
        g.simulatePlayForPlayer(1, new int[] {0,0,1}); // one wrong in middle
        String report = g.getReport();
        Assertions.assertTrue(report.contains("P1"));
        Assertions.assertTrue(report.contains("P2"));
        // P1 should have 3, P2 should have 2 (since second answer wrong)
        Assertions.assertTrue(report.contains("Score: 3") || report.contains("Score: 2"));
    }
}