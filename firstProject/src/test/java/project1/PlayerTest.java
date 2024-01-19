package project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerCreation() {
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);
        assertNotNull(player, "Player object should not be null");
    }

    @Test
    void testGetName() {
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);
        assertEquals("Jeremy Meremy", player.getName(), "Player name should be 'Jeremy Meremy'");
    }

    @Test
    void testGetHeight() {
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);
        assertEquals(playerHeight, player.getHeight(), "Player height should match the provided height object");
    }

    @Test
    void testGetAge() {
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);
        assertEquals(25, player.getAge(), "Player age should be 25");
    }

    @Test
    void testToString() {
        Height playerHeight = new Height(6, 0);
        Player player = new Player("Jeremy Meremy", playerHeight, 25);
        String expectedToString = "Name: Jeremy Meremy, Height: 6'0\", Age: 25 years old";
        assertEquals(expectedToString, player.toString(), "Player toString should match the expected format");
    }

}
