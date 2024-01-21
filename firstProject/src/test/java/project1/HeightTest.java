package project1;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 1
 * Date: January 23rd, 2024
 * Description: This class is responsible for testing the Height class using the JUnit framework.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class HeightTest {

    // Positive test cases
    @Test
    @DisplayName("HeightTest 1")
    void testHeightCreation() {
        // Test the creation of a Height object
        Height height = new Height(5, 9);

        // Assert that the created Height object is not null
        assertNotNull(height, "Height object should not be null");
    }

    @Test
    @DisplayName("HeightTest 2")
    void testToInches() {
        // Test converting Height in feet and inches to total inches
        Height height = new Height(5, 9);

        // Assert that the total inches are correctly calculated
        assertEquals(69, height.toInches(), "5 feet 9 inches should be 69 inches");
    }

    @Test
    @DisplayName("HeightTest 3")
    void testToString() {
        // Test the toString method of Height object
        Height height = new Height(5, 9);

        // Assert that the string representation is as expected
        assertEquals("5'9\"", height.toString(), "String representation of height should be 5'9\"");
    }

    @Test
    @DisplayName("HeightTest 4")
    void testInchesConversion() {
        // Test handling of inches conversion when inches are 12 or more
        Height height = new Height(5, 12);

        // Assert that 5 feet 12 inches is correctly converted to 6 feet 0 inches
        assertEquals("6'0\"", height.toString(), "5 feet 12 inches should be converted to 6 feet 0 inches");
    }

    // Negative test cases
    @Test
    @DisplayName("HeightTest 5")
    void testHeightCreationWithNegativeValues() {
        // Test creating a Height object with negative values for feet and inches
        // Expecting an IllegalArgumentException due to invalid height
        assertThrows(IllegalArgumentException.class, () -> {
            new Height(-1, -1);
        }, "Creating height with negative values should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("HeightTest 6")
    void testHeightCreationWithLargeValues() {
        // Test creating a Height object with excessively large values for feet and
        // inches
        // Expecting an IllegalArgumentException due to unreasonable height values
        assertThrows(IllegalArgumentException.class, () -> {
            new Height(1000, 1000);
        }, "Creating height with excessively large values should throw IllegalArgumentException");
    }
}
