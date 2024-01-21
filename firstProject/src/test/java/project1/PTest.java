package project1;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 1
 * Date: January 23rd, 2024
 * Description: This class is an example of the original test responsible for
 * testing the Player class without using the JUnit testing framework.
 */

public class PTest {

    public static void main(String[] args) {
        testPlayerCreation();
        testGetters();
        testToString();
    }

    private static void testPlayerCreation() {
        Height height = new Height(6, 3);
        Player player = new Player("John Doe", height, 25);
        if (player != null) {
            System.out.println("Test Player Creation: Passed");
        } else {
            System.out.println("Test Player Creation: Failed");
        }
    }

    private static void testGetters() {
        Height height = new Height(6, 3);
        Player player = new Player("John Doe", height, 25);
        boolean passed = true;
        if (!player.getName().equals("John Doe")) {
            System.out.println("Test Get Name: Failed");
            passed = false;
        }
        if (!player.getHeight().equals(height)) {
            System.out.println("Test Get Height: Failed");
            passed = false;
        }
        if (player.getAge() != 25) {
            System.out.println("Test Get Age: Failed");
            passed = false;
        }
        if (passed) {
            System.out.println("Test Getters: Passed");
        }
    }

    private static void testToString() {
        Height height = new Height(6, 3);
        Player player = new Player("John Doe", height, 25);
        String expected = "Name: John Doe, Height: 6'3\", Age: 25 years old";
        String result = player.toString();
        if (expected.equals(result)) {
            System.out.println("Test To String: Passed");
        } else {
            System.out.println("Test To String: Failed (Expected: " + expected + ", Got: " + result + ")");
        }
    }
}
