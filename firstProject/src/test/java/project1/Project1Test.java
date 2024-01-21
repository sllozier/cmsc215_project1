package project1;

import org.junit.jupiter.api.DisplayName;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 1
 * Date: January 23rd, 2024
 * Description: This class is responsible for testing the main method used in
 * the Project1 class using the JUnit framework.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class Project1Test {
    // Positive test cases
    @Test
    @DisplayName("Project1Test 1")
    void findTallestPlayerTest() {
        // Create an ArrayList to hold Player objects
        ArrayList<Player> players = new ArrayList<>();

        // Add several Player objects to the ArrayList with different heights and ages
        players.add(new Player("Emilia", new Height(5, 4), 20));
        players.add(new Player("Victoria", new Height(6, 2), 22));
        players.add(new Player("Lillian", new Height(6, 3), 23));
        players.add(new Player("Leo", new Height(5, 9), 19));
        players.add(new Player("Robert", new Height(6, 0), 18));

        // Calculate the total age of all players to find the average age
        double totalAge = 0;
        for (Player player : players) {
            totalAge += player.getAge();
        }
        double avgAge = totalAge / players.size(); // Average age calculation

        // Call the method findTallestPlayer from Project1 and store the result
        // The method should find the tallest player who is younger than or equal to the
        // average age
        Player tallestPlayer = Project1.findTallestPlayer(players, avgAge);

        // Assert that the name of the tallest player is "Robert"
        // This checks if the method correctly identified the tallest player under the
        // given conditions
        assertEquals("Robert", tallestPlayer.getName(),
                "Robert is the tallest player younger than or equal to average age");
    }

    @Test
    @DisplayName("Project1Test 2")
    void testAllPlayersSameHeightAndAge() {
        // Create an ArrayList to hold Player objects
        ArrayList<Player> players = new ArrayList<>();

        // Add five Player objects to the ArrayList with the same height and age
        // This simulates a scenario where all players have identical height and age
        for (int i = 0; i < 5; i++) {
            players.add(new Player("Player" + i, new Height(6, 0), 25));
        }

        // Set the average age to 25, which is the same as the age of all players
        double avgAge = 25;

        // Call the method findTallestPlayer from Project1 with the players list and the
        // average age
        // Since all players have the same height and age, the method should return a
        // non-null player
        assertNotNull(Project1.findTallestPlayer(players, avgAge), "Same height and age should be handled correctly");
    }

    // Negative test cases
    @Test
    @DisplayName("Project1Test 3")
    void testInvalidNameInput() {
        // Create an empty ArrayList of Player objects to simulate no valid players
        // added
        ArrayList<Player> players = new ArrayList<>();

        // Set a simplified total age for test purposes
        double totalAge = 20;

        // Call the method findTallestPlayer from Project1 with the empty players list
        // Since no valid players are added, the method should return null
        Player tallestPlayer = Project1.findTallestPlayer(players, totalAge);
        assertNull(tallestPlayer, "Players with invalid names should not be processed");
    }

    @Test
    @DisplayName("Project1Test 4")
    void testNegativeHeightInput() {
        // Test the creation of a Player object with negative height values
        // Expect an IllegalArgumentException to be thrown due to the invalid height
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("Emily", new Height(-1, -1), 20); // Invalid height
        }, "Creating a player with negative height should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Project1Test 5")
    void testNoPlayers() {
        // Create an empty ArrayList of Player objects to simulate a scenario with no
        // players
        ArrayList<Player> players = new ArrayList<>();

        // Set average age to 0 for this test, as there are no players to calculate an
        // average
        double avgAge = 0;

        // Call the method findTallestPlayer from Project1 with the empty players list
        // Since there are no players, the method should return null
        assertNull(Project1.findTallestPlayer(players, avgAge), "No players should be handled gracefully");
    }
}
