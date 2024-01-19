package project1;

public class Height {
    private final int feet;
    private final int inches;

    public Height(int feet, int inches) {
        this.feet = feet + inches / 12; // Convert excess inches to feet
        this.inches = inches % 12; // Remainder inches
    }

    public int toInches() {

        return (this.feet * 12) + this.inches;
    }

    @Override
    public String toString() {
        return this.feet + "'" + this.inches + "\"";
    }
}
