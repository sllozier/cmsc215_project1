package project1;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 1
 * Date: January 23rd, 2024
 * Description: This class represents a player, encapsulating properties like
 * name, age, and height.
 * It provides methods to access and modify these properties, and may include
 * other player-related operations.
 */

// Player class represents a players data with name, height, and age
public class Player {

    // Immutable instance variables for player's name, height and age
    private final String playerName;
    private final Height playerHeight;
    private final int playerAge;

    // Constructor: Initializes a Player object with the provided name, height and
    // age
    public Player(String playerName, Height playerHeight, int playerAge) {
        // Validate player name and height are not null; player age isn't a negative
        // number
        if (playerName == null) {
            throw new IllegalArgumentException("Player name cannot be null");
        }
        if (playerHeight == null) {
            throw new IllegalArgumentException("Player height cannot be null");
        }
        if (playerAge < 0) {
            throw new IllegalArgumentException("Player age cannot be negative");
        }
        this.playerName = playerName;
        this.playerHeight = playerHeight;
        this.playerAge = playerAge;
    }

    // Getter method for player's name
    public String getName() {
        return this.playerName;
    }

    // Getter method for player's height
    public Height getHeight() {
        return this.playerHeight;
    }

    // Getter method for player's age
    public int getAge() {
        return this.playerAge;
    }

    // Overridden toString method to return the string representation of a Player
    // object [see note in Height class for why @override is used]
    // Concatenates player's name, height (using Height's toString method), and age
    @Override
    public String toString() {
        return "Name: " + this.playerName + ", Height: " + this.playerHeight.toString() + ", Age: " + this.playerAge
                + " years old";
    }
}
