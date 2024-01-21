package project1;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 1
 * Date: January 23rd, 2024
 * Description: This class is responsible for testing the Player class using the
 * JUnit framework.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

class PlayerTest {

    // Positive test cases
    @Test
    @DisplayName("PlayerTest 1")
    void testPlayerCreation() {
        // Test the successful creation of a Player object
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);

        // Assert that the created player object is not null
        assertNotNull(player, "Player object should not be null");
    }

    @Test
    @DisplayName("PlayerTest 2")
    void testGetName() {
        // Test getting the name from a Player object
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);

        // Assert that the name retrieved matches the expected name
        assertEquals("Jeremy Meremy", player.getName(), "Player name should be 'Jeremy Meremy'");
    }

    @Test
    @DisplayName("PlayerTest 3")
    void testGetHeight() {
        // Test getting the height from a Player object
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);

        // Assert that the height retrieved matches the expected height object
        assertEquals(playerHeight, player.getHeight(), "Player height should match the provided height object");
    }

    @Test
    @DisplayName("PlayerTest 4")
    void testGetAge() {
        // Test getting the age from a Player object
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);

        // Assert that the age retrieved matches the expected age
        assertEquals(25, player.getAge(), "Player age should be 25");
    }

    @Test
    @DisplayName("PlayerTest 5")
    void testToString() {
        // Test the toString method of a Player object
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);

        // Define the expected string representation of the Player
        String expectedToString = "Name: Jeremy Meremy, Height: 6'0\", Age: 25 years old";

        // Assert that the actual string representation matches the expected one
        assertEquals(expectedToString, player.toString(), "Player toString should match the expected format");
    }

    // Negative test cases
    @Test
    @DisplayName("PlayerTest 6")
    void testPlayerCreationWithNullName() {
        // Test creating a Player with a null name, expecting an
        // IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null, new Height(6, 0), 25);
        }, "Creating a player with null name should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("PlayerTest 7")
    void testPlayerCreationWithNullHeight() {
        // Test creating a Player with a null height, expecting an
        // IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("Jeremy Meremy", null, 25);
        }, "Creating a player with null height should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("PlayerTest 8")
    void testPlayerCreationWithNegativeAge() {
        // Test creating a Player with a negative age, expecting an
        // IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("Jeremy Meremy", new Height(6, 0), -1);
        }, "Creating a player with negative age should throw IllegalArgumentException");
    }

}
