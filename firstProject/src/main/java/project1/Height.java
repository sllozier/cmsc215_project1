package project1;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 1
 * Date: January 23rd, 2024
 * Description: This class is responsible for managing the height information of
 * players.
 * It includes methods to store and retrieve height data, as well as any other
 * height-related functionalities.
 */

// Height class represents player's height in feet and inches
public class Height {
    // Immutable instance variables for feet and inches
    private final int feet;
    private final int inches;

    // Constructor: Initializes Height object with given feet and inches
    // Sets height so that inches are less than 12
    public Height(int feet, int inches) {
        // Validate feet or inches aren't negative; Height values are not too high
        if (feet < 0 || inches < 0) {
            throw new IllegalArgumentException("Height cannot have negative values");
        }
        if (feet > 7 || inches > 12) {
            throw new IllegalArgumentException("Height values are too large");
        }
        this.feet = feet + inches / 12; // Convert excess inches to feet
        this.inches = inches % 12; // Keep only remainer inches
    }

    // Method to calculate and return the height in total inches
    public int toInches() {
        return (this.feet * 12) + this.inches; // Converts feet to inches and adds inches
    }

    // Overridden toString method to return the string representation of the height
    // By default, the toString method in the Object class returns a string that
    // consists of the class name followed by the object's hash code. Overriding
    // this method allows me to return a more meaningful and readable
    // representation, specifically the height in feet and inches format.
    @Override
    public String toString() {
        return this.feet + "'" + this.inches + "\"";
    }
}
