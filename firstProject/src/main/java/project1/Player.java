package project1;

public class Player {
    private final String playerName;
    private final Height playerHeight;
    private final int playerAge;

    public Player(String playerName, Height playerHeight, int playerAge) {
        this.playerName = playerName;
        this.playerHeight = playerHeight;
        this.playerAge = playerAge;
    }

    public String getName() {
        return this.playerName;
    }

    public Height getHeight() {
        return this.playerHeight;
    }

    public int getAge() {
        return this.playerAge;
    }

    @Override
    public String toString() {
        return "Name: " + this.playerName + ", Height: " + this.playerHeight.toString() + ", Age: " + this.playerAge
                + " years old";
    }
}
