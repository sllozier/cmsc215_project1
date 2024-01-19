package project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @Test
    void testHeightCreation() {
        Height height = new Height(5, 9);
        assertNotNull(height, "Height object should not be null");
    }

    @Test
    void testToInches() {
        Height height = new Height(5, 9);
        assertEquals(69, height.toInches(), "5 feet 9 inches should be 69 inches");
    }

    @Test
    void testToString() {
        Height height = new Height(5, 9);
        assertEquals("5'9\"", height.toString(), "String representation of height should be 5'9\"");
    }

    @Test
    void testInchesConversion() {
        Height height = new Height(5, 12);
        assertEquals("6'0\"", height.toString(), "5 feet 12 inches should be converted to 6 feet 0 inches");
    }
}
