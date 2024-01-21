package project1;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 1
 * Date: January 23rd, 2024
 * Description: This is the main class for the player analysis program. It
 * contains the main method
 * which orchestrates the creation of player objects, handling of height data,
 * and the logic to find the tallest
 * player whose age is less than or equal to the average age of all players.
 */

import java.util.Scanner;
import java.util.ArrayList;

// Project1 class contains the main method to run this program
public class Project1 {
    public static void main(String[] args) {
        // Scanner object for reading input from the console
        Scanner scnr = new Scanner(System.in);

        // ArrayList to store Player objects. ArrayList is chosen for its dynamic size
        // and ease of use
        ArrayList<Player> players = new ArrayList<>();
        int totalAge = 0;

        // A do...while loop is used here instead of a while loop because we want to
        // execute the loop body at least once. This approach ensures that the user is
        // always prompted to enter at least one player's information before checking
        // the condition to continue or stop.
        System.out.println("\n" + "\t     🖖Welcome to the player height program!🖖");
        do {
            System.out.println("-------------------------------------------------------------------" + "\n"); // Area
                                                                                                              // Heading

            // Reading player data: name, height(feet and inches) and age
            // Validation: 4 do...while loops to validate input and prompt the user to
            // re-enter data if necessary
            String name;
            boolean validName;

            System.out.println("Enter player first name (letters  🅰  — 🆉  or '—'): ");
            name = scnr.nextLine();
            // Check if the input is a string with valid characters using isValidName method
            validName = isValidName(name);

            // If the name isn't valid prompt user to re-enter it
            if (!validName) {
                System.out.println("Invalid name! Please use only letters 🅰  — 🆉  or '—'.");
                continue; // Skip the rest of the loop iteration if the name is invalid
            }

            int feet = 0;
            boolean validFeet;

            do {
                System.out.println("Enter player height (feet 🦶): ");

                // Check if the input is a valid integer
                if (scnr.hasNextInt()) {
                    feet = scnr.nextInt();
                    validFeet = feet >= 0; // Check for non-negative value
                    if (!validFeet) {
                        System.out.println("Height cannot be negative. Please enter a valid height (feet 🦶).");
                    }
                } else {
                    validFeet = false;
                    System.out.println("Invalid input! Please enter a valid integer for height (feet 🦶).");
                    scnr.next(); // Clear the invalid input
                }
            } while (!validFeet);
            scnr.nextLine(); // Common practice to clear the input buffer, particularly important if the next
                             // input is not an integer

            int inches = 0;
            boolean validInches;

            do {
                System.out.println("Enter player height (inches 🪱): ");

                // Check if the input is a valid integer
                if (scnr.hasNextInt()) {
                    inches = scnr.nextInt();
                    validInches = true;
                } else {
                    validInches = false;
                    System.out.println("Invalid input! Please enter a valid integer for height (inches 🪱).");
                    scnr.next(); // Clear the invalid input
                }
            } while (!validInches);

            scnr.nextLine(); // [see above comment]

            int age = 0; // Initialize with default value
            boolean validAge;

            do {
                System.out.println("Enter player age 🎂: ");

                // Check if the input is a valid integer
                if (scnr.hasNextInt()) {
                    age = scnr.nextInt();
                    validAge = true;
                } else {
                    validAge = false;
                    System.out.println("Invalid input! Please enter a valid integer for age 🎂.");
                    scnr.next(); // Clear the invalid input
                }
            } while (!validAge);
            scnr.nextLine(); // [see above comment]

            // Check if the input name is valid using isValidName method
            if (isValidName(name)) {
                // Create and add player only if the name is valid
                Height height = new Height(feet, inches);
                Player player = new Player(name, height, age);
                players.add(player);
                totalAge += age;
            } else {
                System.out.println("Invalid name! Player not added.");
                continue; // Skip adding the player with invalid name
            }

            // Prompt the user to decide if they want to add another player
            // The loop continues if user inputs 'y' (case insensitive), otherwise the loop
            // stops
            System.out.println("Do you want to add another player? (y/n)");
        } while (scnr.nextLine().equalsIgnoreCase("y"));

        System.out.println("\n" + "\t\t\t   📊 Results 📊");
        System.out.println("-------------------------------------------------------------------" + "\n"); // Area
                                                                                                          // Heading

        // Calculate the average age of the players in the ArrayList
        double avgAge = (double) totalAge / players.size(); // Using ArrayList (built-in) method .size to calculate
                                                            // average
        System.out.println("Average age of players ⛹ ⛹ ⛹ : " + avgAge + "\n");

        // Using method findTallestPlayer to find and display the tallest player younger
        // than or equal to the average age
        Player tallestPlayer = findTallestPlayer(players, avgAge);
        if (tallestPlayer != null) {
            System.out
                    .println(
                            "📢 The tallest player younger than or equal to the average age is: " + "\n" + tallestPlayer
                                    + "\n");
        } else {
            System.out.println("❗❗No player was found who is younger than or equal to the average age.");
        }
    }

    // Method to find the tallest player who is younger than or equal to the average
    // age
    public static Player findTallestPlayer(ArrayList<Player> players, double avgAge) {
        Player tallestPlayer = null;
        int maxHeightInches = 0;

        // Iterate over the players ArrayList to find the tallest one meeting the age
        // condition
        for (Player player : players) {
            int playerHeightInches = player.getHeight().toInches();
            if (player.getAge() <= avgAge && playerHeightInches > maxHeightInches) {
                tallestPlayer = player; // Update the tallest player found so far
                maxHeightInches = playerHeightInches; // Update the maxiumum height to the new tallest player's height
            }
        }
        return tallestPlayer;
    }

    // Validation method for checking if the name contains only letters A-Z (not
    // case-specific) or '-'
    public static boolean isValidName(String name) {
        return name.matches("^[A-Za-z\\-]+$");
    }
}