package project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class Project1Test {

    @Test
    void findTallestPlayerTest() {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player("Emilia", new Height(5, 4), 20));
        players.add(new Player("Victoria", new Height(6, 2), 22));
        players.add(new Player("Lillian", new Height(6, 3), 23));
        players.add(new Player("Leo", new Height(5, 9), 19));
        players.add(new Player("Robert", new Height(6, 0), 18));

        double totalAge = 0;
        for (Player player : players) {
            totalAge += player.getAge();
        }
        double avgAge = totalAge / players.size();

        Player tallestPlayer = Project1.findTallestPlayer(players, avgAge);
        assertEquals("Robert", tallestPlayer.getName(),
                "Robert is the tallest player younger than or equal to average age");
    }
}
