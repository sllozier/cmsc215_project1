package project1;

import java.util.Scanner;
import java.util.ArrayList;

public class Project1 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        int totalAge = 0;

        do {
            System.out.println("Enter player name: ");
            String name = scnr.nextLine();

            System.out.println("Enter player height (feet): ");
            int feet = scnr.nextInt();

            System.out.println("Enter player height (inches): ");
            int inches = scnr.nextInt();
            scnr.nextLine();

            System.out.println("Enter player age: ");
            int age = scnr.nextInt();
            scnr.nextLine();

            Height height = new Height(feet, inches);
            Player player = new Player(name, height, age);
            players.add(player);
            totalAge += age;

            System.out.println("Do you want to add another player? (y/n)");
        } while (scnr.nextLine().equalsIgnoreCase("y"));

        double avgAge = (double) totalAge / players.size();
        System.out.println("Average age of players: " + avgAge);

        Player tallestPlayer = findTallestPlayer(players, avgAge);
        if (tallestPlayer != null) {
            System.out.println("The tallest player younger than or equal to the average age is: " + tallestPlayer);
        } else {
            System.out.println("No player was found who is younger than or equal to the average age.");
        }
    }

    public static Player findTallestPlayer(ArrayList<Player> players, double avgAge) {
        Player tallestPlayer = null;
        int maxHeightInches = 0;

        for (Player player : players) {
            int playerHeightInches = player.getHeight().toInches();
            if (player.getAge() <= avgAge && playerHeightInches > maxHeightInches) {
                tallestPlayer = player;
                maxHeightInches = playerHeightInches;
            }
        }
        return tallestPlayer;
    }
}